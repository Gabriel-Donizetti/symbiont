package com.hub.br.symbiont.infra.seeds;

import com.hub.br.symbiont.domain.model.*;
import com.hub.br.symbiont.infra.repository.ClientRepository;
import com.hub.br.symbiont.infra.repository.RoleRepository;
import com.hub.br.symbiont.infra.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AdminPanelSeed implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        Client client = clientRepository.findByClientId("symbiont-admin")
                .orElseGet(() -> {
                    Client c = Client.builder()
                            .clientId("symbiont-admin")
                            .clientSecret(passwordEncoder.encode("symbiont-secret"))
                            .name("Symbiont Admin Console")
                            .redirectUri("https://www.youtube.com/")
                            .confidential(true)
                            .active(true)
                            .createdAt(LocalDateTime.now())
                            .build();
                    return clientRepository.save(c);
                });

        Role superAdminRole = roleRepository.findByName("SUPER_ADMIN")
                .orElseGet(() -> {
                    Role r = Role.builder()
                            .name("SUPER_ADMIN")
                            .description("System administrator with full access")
                            .client(client) 
                            .build();
                    return roleRepository.save(r);
                });

        userRepository.findByUsername("admin").orElseGet(() -> {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .fullName("System Administrator")
                    .email("admin@symbiont.local")
                    .roles(List.of(superAdminRole))
                    .active(true)
                    .build();
            return userRepository.save(admin);
        });

        System.out.println("✅ System seed completed.");
    }
}
