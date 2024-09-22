package com.nexcodelab.agendaclinicaser.application.user.paciente.service;

import com.nexcodelab.agendaclinicaser.application.user.paciente.dto.request.CadastrarPacienteRequest;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.application.user.persona.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService extends PersonaService<Paciente> {

    public Paciente execute(CadastrarPacienteRequest request) {
        return super.cadastrar(toPaciente(request));
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
