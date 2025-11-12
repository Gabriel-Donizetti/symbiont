package com.hub.br.symbiont.application.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hub.br.symbiont.application.auth.dto.AuthDto;
import com.hub.br.symbiont.application.auth.dto.SignInDto;
import com.hub.br.symbiont.domain.model.Client;
import com.hub.br.symbiont.domain.model.User;
import com.hub.br.symbiont.infra.repository.ClientRepository;
import com.hub.br.symbiont.infra.repository.UserRepository;
import com.hub.br.symbiont.infra.security.TokenService;

import jakarta.validation.Valid;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public String login(AuthDto dto) {

        Client client = clientRepository.findById(dto.clientid())
                .orElseThrow(() -> new RuntimeException("Cliente inválido"));

        User user = userRepository.findByEmailOrLogin(dto.username())
                .orElseThrow(() -> new UsernameNotFoundException("Credenciais inválidas"));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        user.setClient(client);

        String token = tokenService.generateToken(user);

        System.out.println();
        System.out.println(String.format("%s?token=%s", client.getRedirectUri(), token));
        System.out.println();

        return String.format("%s?token=%s", client.getRedirectUri(), token);
    }

    public String register(SignInDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    public void logout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

    public String refresh(SignInDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refresh'");
    }

}
