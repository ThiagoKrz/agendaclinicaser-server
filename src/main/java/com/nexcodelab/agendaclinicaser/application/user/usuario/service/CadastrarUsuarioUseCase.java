package com.nexcodelab.agendaclinicaser.application.user.usuario.service;

import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import com.nexcodelab.agendaclinicaser.application.user.usuario.repository.UsuarioRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;


    @Transactional
    public Usuario execute(String username, String password, Role role) {
        if (usuarioRepository.existsByUsername(username)) {
            throw new BusinessRuleException("Username já está sendo utilizado");
        }


        return usuarioRepository.save(new Usuario(username, encoder.encode(password), role,  true));
    }
}
