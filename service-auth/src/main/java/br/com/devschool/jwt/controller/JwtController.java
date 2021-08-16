package br.com.devschool.jwt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class JwtController {

    @GetMapping
    public String helloWorld() {
       return "Hello World";
    }

}
