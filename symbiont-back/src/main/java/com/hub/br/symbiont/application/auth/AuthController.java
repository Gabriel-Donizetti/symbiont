package com.hub.br.symbiont.application.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hub.br.symbiont.application.auth.dto.AuthDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Endpoints para autenticação e registro de usuário")
public class AuthController {

    @Autowired
    private AuthService service;

    @Operation(summary = "Realiza a autenticação do usuário", description = "Autentica um usuário e retorna um token JWT", method = "POST")
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody @Valid AuthDto dto) {
        String redirectUrl = service.login(dto);
        return ResponseEntity.status(302)
                .header("Location", redirectUrl)
                .build();
    }

    @Operation(summary = "Registra um novo usuário", description = "Registra um novo usuário no sistema", method = "POST")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid AuthDto dto) {
        String redirectUrl = service.register(dto);
        return ResponseEntity.status(302)
                .header("Location", redirectUrl)
                .build();
    }

    @Operation(summary = "Realiza logout do usuário", description = "Encerra a sessão do usuário", method = "POST")
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        service.logout();
        return ResponseEntity.ok().build(); 
    }

}
