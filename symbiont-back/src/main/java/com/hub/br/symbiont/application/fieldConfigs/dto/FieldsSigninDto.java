package com.hub.br.symbiont.application.fieldConfigs.dto;

import java.util.List;

public record FieldsSigninDto(
    List<FieldDto> fields
) {
    public record FieldDto(
        String name,
        String validatorRegex,
        boolean required // mantemos isso, pois pode haver campos visíveis mas opcionais
    ) {}
}
