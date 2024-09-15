package com.nexcodelab.agendaclinicaser.application.user.supervisor.service;

import com.nexcodelab.agendaclinicaser.application.user.persona.service.CadastrarPersonaUseCase;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.dto.request.CadastrarSupervisorRequest;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.model.Supervisor;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import com.nexcodelab.agendaclinicaser.application.user.usuario.service.CadastrarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarSupervisorUseCase extends CadastrarPersonaUseCase<Supervisor> {
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    public Supervisor execute(CadastrarSupervisorRequest request) {
        Usuario usuario = cadastrarUsuarioUseCase.execute(request.getUsername(), request.getPassword(), Role.SUPERVISOR);

        return super.execute(toSupervisor(request, usuario));
    }

    private Supervisor toSupervisor(CadastrarSupervisorRequest request, Usuario usuario) {
        return new Supervisor(
                usuario,
                request.getNome(),
                request.getSobrenome(),
                request.getDataNascimento(),
                request.getSexo(),
                request.getEmail(),
                request.getDdd(),
                request.getNumeroTelefone()
        );
    }

}
