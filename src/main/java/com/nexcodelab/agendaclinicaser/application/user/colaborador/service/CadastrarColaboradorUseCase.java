package com.nexcodelab.agendaclinicaser.application.user.colaborador.service;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.request.CadastrarColaboradorRequest;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
import com.nexcodelab.agendaclinicaser.application.user.persona.service.CadastrarPersonaUseCase;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.application.user.usuario.service.CadastrarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarColaboradorUseCase extends CadastrarPersonaUseCase<Colaborador> {
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    public Colaborador execute(CadastrarColaboradorRequest request) {
        Usuario usuario = cadastrarUsuarioUseCase.execute(request.getUsername(), request.getPassword(), request.getPerfilAcessoId());

        return super.execute(toColaborador(request, usuario));
    }

    private Colaborador toColaborador(CadastrarColaboradorRequest request, Usuario usuario) {
        return new Colaborador(
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
