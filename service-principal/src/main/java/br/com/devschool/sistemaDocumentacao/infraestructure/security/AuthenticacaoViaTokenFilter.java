package br.com.devschool.sistemaDocumentacao.infraestructure.security;

import br.com.devschool.sistemaDocumentacao.domain.external.client.JwtClient;
import br.com.devschool.sistemaDocumentacao.domain.external.client.User;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.user.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticacaoViaTokenFilter extends OncePerRequestFilter {

    private UserRepository userRepository;
    private JwtClient jwtClient;

    public AuthenticacaoViaTokenFilter(JwtClient jwtClient, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.jwtClient = jwtClient;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = recuperarToken(request);

        Long userId = null;
        if (token != null) {
            userId = jwtClient.getUserId(token);

            User usuario = userRepository.findById(userId).get();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        System.out.println("cheguei aqui");

        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
}
