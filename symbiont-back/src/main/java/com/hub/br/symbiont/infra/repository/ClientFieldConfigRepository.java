package com.hub.br.symbiont.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hub.br.symbiont.domain.model.ClientFieldConfig;

public interface ClientFieldConfigRepository extends JpaRepository<ClientFieldConfig, UUID> {

}
