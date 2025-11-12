package com.hub.br.symbiont.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hub.br.symbiont.domain.model.UserFieldConfig;

import java.util.List;
import java.util.UUID;

public interface UserFieldConfigRepository extends JpaRepository<UserFieldConfig, UUID> {

    List<UserFieldConfig> findByVisibleTrue();

}
