package com.hub.br.symbiont.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hub.br.symbiont.domain.model.UserAttribute;
import java.util.UUID;

public interface UserAttributeRepository extends JpaRepository<UserAttribute, UUID> {
}
