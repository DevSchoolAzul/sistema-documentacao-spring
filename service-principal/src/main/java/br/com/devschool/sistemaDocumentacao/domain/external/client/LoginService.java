package br.com.devschool.sistemaDocumentacao.domain.external.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private JwtClient jwtClient;

    public TokenDto getToken(LoginDto loginDto) {
        return jwtClient.getToken(loginDto);
    }

}
