package com.nexcodelab.agendaclinicaser.application.user.usuario.service;

import com.nexcodelab.agendaclinicaser.application.user.usuario.model.PerfilAcesso;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.application.user.usuario.repository.PerfilAcessoRepository;
import com.nexcodelab.agendaclinicaser.application.user.usuario.repository.UsuarioRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.BadRequestRestException;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.BusinessRuleException;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;
    private final PerfilAcessoRepository perfilAcessoRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public Usuario execute(String username, String password, Long perfilAcessoId) {
        if (usuarioRepository.existsByUsername(username)) {
            throw new BusinessRuleException("Username já está sendo utilizado");
        }

        PerfilAcesso perfilAcesso = perfilAcessoRepository.findById(perfilAcessoId)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil de acesso não encontrado"));

        return usuarioRepository.save(new Usuario(username, encoder.encode(password), perfilAcesso,  true));
    }

}
