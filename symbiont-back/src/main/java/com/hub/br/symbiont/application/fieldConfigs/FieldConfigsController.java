package com.hub.br.symbiont.application.fieldConfigs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hub.br.symbiont.application.response.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/fields")
@Tag(name = "Auth", description = "Endpoints manipular os campos de cadastro de usuario")
public class FieldConfigsController {

    @Autowired
    private FieldConfigsService service;

    @Operation(summary = "Get campos de cadastro", description = "Retorna os campos de cadastro que estão ativados para serem renderizados no front", method = "GET")
    @GetMapping("/fields")
    public ResponseEntity<ApiResponse> getMethodName(@RequestParam String param) {
         service.getSigninFields();
        return ResponseEntity.ok().build(); 
    }
}
