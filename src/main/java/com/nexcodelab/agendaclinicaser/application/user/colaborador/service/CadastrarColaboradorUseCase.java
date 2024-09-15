package com.nexcodelab.agendaclinicaser.application.user.colaborador.service;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.request.CadastrarColaboradorRequest;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
import com.nexcodelab.agendaclinicaser.application.user.persona.service.CadastrarPersonaUseCase;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import com.nexcodelab.agendaclinicaser.application.user.usuario.service.CadastrarUsuarioUseCase;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastrarColaboradorUseCase extends CadastrarPersonaUseCase<Colaborador> {
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    public Colaborador execute(CadastrarColaboradorRequest request) {
        validarRole(request.getRole());
        Usuario usuario = cadastrarUsuarioUseCase.execute(request.getUsername(), request.getPassword(), request.getRole());

        return super.execute(toColaborador(request, usuario));
    }

    private void  validarRole(Role role){
        List<Role> rolesPermitidas = List.of(Role.ADMIN, Role.RECEPCAO);
        if(!rolesPermitidas.contains(role)) {
            throw new BusinessRuleException("Perfil de acesso inválido");
        }
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
