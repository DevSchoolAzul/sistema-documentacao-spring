package br.com.devschool.jwt.controller;

import br.com.devschool.jwt.dto.LoginDTO;
import br.com.devschool.jwt.dto.TokenDTO;
import br.com.devschool.jwt.config.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDTO> auth(@RequestBody @Validated LoginDTO loginDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = tokenService.generateToken(authentication);

        return ResponseEntity.ok(TokenDTO.builder()
                .type("Bearer")
                .token(token)
                .build());
    }

    @PostMapping("/user")
    public ResponseEntity<Long> getUserId(@RequestBody String token) {
        if(tokenService.isTokenValido(token)) {
            Long userId = tokenService.getIdUsuario(token);
            return ResponseEntity.ok(userId);
        }
        return ResponseEntity.badRequest().build();
    }

}
