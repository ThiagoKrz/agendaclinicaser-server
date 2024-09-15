package com.nexcodelab.agendaclinicaser.application.user.estagiario.service;

import com.nexcodelab.agendaclinicaser.application.user.estagiario.dto.request.CadastrarEstagiarioRequest;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.model.Estagiario;
import com.nexcodelab.agendaclinicaser.application.user.persona.service.CadastrarPersonaUseCase;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.application.user.usuario.service.CadastrarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarEstagiarioUseCase extends CadastrarPersonaUseCase<Estagiario> {
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    public Estagiario execute(CadastrarEstagiarioRequest request) {
        Usuario usuario = cadastrarUsuarioUseCase.execute(request.getUsername(), request.getPassword(), request.getRole());

        return super.execute(toEstagiario(request, usuario));
    }

    private Estagiario toEstagiario(CadastrarEstagiarioRequest request, Usuario usuario) {
        return new Estagiario(
                usuario,
                request.getHorasRequeridas(),
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
