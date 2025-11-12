package com.hub.br.symbiont.application.fieldConfigs;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hub.br.symbiont.application.fieldConfigs.dto.FieldsSigninDto;
import com.hub.br.symbiont.domain.model.UserFieldConfig;
import com.hub.br.symbiont.infra.repository.UserFieldConfigRepository;

@Service
public class FieldConfigsService { 

   @Autowired
    private UserFieldConfigRepository repository;

    
}
