package com.nexcodelab.agendaclinicaser.application.user.paciente.service;

import com.nexcodelab.agendaclinicaser.application.user.paciente.dto.request.CadastrarPacienteRequest;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.application.user.persona.service.CadastrarPersonaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarPacienteUseCase extends CadastrarPersonaUseCase<Paciente> {

    public Paciente execute(CadastrarPacienteRequest request) {
        return super.execute(toPaciente(request));
    }

    private Paciente toPaciente(CadastrarPacienteRequest request) {
        return new Paciente(
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
