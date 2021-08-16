package br.com.devschool.sistemaDocumentacao.domain.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("jwt")
public interface SeilaCliente {

    @GetMapping("/auth")
    String helloWorld();

}
