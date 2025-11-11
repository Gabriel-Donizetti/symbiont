package com.hub.br.symbiont.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hub.br.symbiont.domain.model.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(String name);

}
