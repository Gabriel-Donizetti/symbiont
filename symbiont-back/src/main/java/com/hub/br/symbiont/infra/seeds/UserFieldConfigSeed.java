package com.hub.br.symbiont.infra.seeds;

import com.hub.br.symbiont.domain.model.UserFieldConfig;
import com.hub.br.symbiont.infra.repository.UserFieldConfigRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserFieldConfigSeed {

    @Bean
    public CommandLineRunner seedUserFieldConfig(UserFieldConfigRepository repository) {
        return args -> {
            if(repository.count() == 0) { 
                List<UserFieldConfig> fields = List.of(
                        UserFieldConfig.builder()
                                .fieldName("fullName")
                                .required(true)
                                .visible(true)
                                .validatorRegex(".{2,100}") 
                                .build(),
                        UserFieldConfig.builder()
                                .fieldName("birthDate")
                                .required(true)
                                .visible(true)
                                .validatorRegex("\\d{4}-\\d{2}-\\d{2}") 
                                .build(),
                        UserFieldConfig.builder()
                                .fieldName("gender")
                                .required(false)
                                .visible(true)
                                .validatorRegex("M|F|O") 
                                .build(),
                        UserFieldConfig.builder()
                                .fieldName("maritalStatus")
                                .required(false)
                                .visible(true)
                                .validatorRegex(".{0,50}")
                                .build(),
                        UserFieldConfig.builder()
                                .fieldName("cpf")
                                .required(true)
                                .visible(true)
                                .validatorRegex("\\d{11}")
                                .build(),
                        UserFieldConfig.builder()
                                .fieldName("email")
                                .required(true)
                                .visible(true)
                                .validatorRegex(".+@.+\\..+")
                                .build(),
                        UserFieldConfig.builder()
                                .fieldName("phone")
                                .required(false)
                                .visible(true)
                                .validatorRegex("\\d{10,11}")
                                .build()
                );

                repository.saveAll(fields);
                System.out.println("✅ UserFieldConfig seed completed.");
            }
        };
    }
}
