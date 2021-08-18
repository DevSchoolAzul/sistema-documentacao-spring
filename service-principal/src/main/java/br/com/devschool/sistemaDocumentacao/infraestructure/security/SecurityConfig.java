package br.com.devschool.sistemaDocumentacao.infraestructure.security;


import br.com.devschool.sistemaDocumentacao.domain.external.client.JwtClient;
import br.com.devschool.sistemaDocumentacao.domain.external.client.User;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtClient jwtClient;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(authenticationService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login/**").permitAll()
                .antMatchers(HttpMethod.GET, "/projetos").permitAll()
                .antMatchers(HttpMethod.GET, "/versoes").permitAll()
                .antMatchers(HttpMethod.GET, "/telas").permitAll()
                .antMatchers(HttpMethod.GET, "/eventos").permitAll()
                .antMatchers(HttpMethod.GET, "/tiposEvento").permitAll()
                .antMatchers(HttpMethod.GET, "/requisicoes").permitAll()
                .antMatchers(HttpMethod.GET, "/propriedades").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AuthenticacaoViaTokenFilter(jwtClient,userRepository), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }



}
