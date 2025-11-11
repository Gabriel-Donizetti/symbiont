package com.hub.br.symbiont.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "user_field_config")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFieldConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String fieldName;

    private boolean required;

    private boolean visible;

    private String validatorRegex;
}
