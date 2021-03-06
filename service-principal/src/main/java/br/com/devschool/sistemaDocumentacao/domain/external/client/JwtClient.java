package br.com.devschool.sistemaDocumentacao.domain.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("jwt")
public interface JwtClient {

    @PostMapping("/auth")
    TokenDto getToken(LoginDto loginDto);

    @PostMapping("/auth/user")
    Long getUserId(String token);
}
