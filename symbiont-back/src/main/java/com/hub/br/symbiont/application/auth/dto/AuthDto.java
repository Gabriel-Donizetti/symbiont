package com.hub.br.symbiont.application.auth.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthDto(
        @NotNull(message = "ClientID não pode ser null") UUID clientid,
        @NotBlank(message = "Login não pode ser vazio") String username,
        @NotBlank(message = "Senha não pode ser vazia") String password) {

}
