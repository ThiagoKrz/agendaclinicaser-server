package com.nexcodelab.agendaclinicaser.application.user.persona.service;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.request.CadastrarColaboradorRequest;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.dto.request.CadastrarEstagiarioRequest;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.model.Estagiario;
import com.nexcodelab.agendaclinicaser.application.user.paciente.dto.request.CadastrarPacienteRequest;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import com.nexcodelab.agendaclinicaser.application.user.persona.repository.PersonaRepository;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.dto.request.CadastrarSupervisorRequest;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.model.Supervisor;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.application.user.usuario.service.CadastrarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarPersonaUseCase<T extends Persona> {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    @Autowired
    protected PersonaRepository<T> repository;

    public T execute(CadastrarPacienteRequest request) {
        Paciente paciente = new Paciente(
                request.getNome(),
                request.getSobrenome(),
                request.getDataNascimento(),
                request.getSexo(),
                request.getEmail(),
                request.getDdd(),
                request.getNumeroTelefone()
        );

        return cadastrar((T) paciente);
    }

    public T execute(CadastrarEstagiarioRequest request) {
        Usuario usuario = cadastrarUsuario(request.getUsername(), request.getPassword(), request.getPerfilAcessoId());

        Estagiario estagiario = new Estagiario(
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

        return cadastrar((T) estagiario);
    }
    public T execute(CadastrarSupervisorRequest request) {
        Usuario usuario = cadastrarUsuario(request.getUsername(), request.getPassword(), request.getPerfilAcessoId());

        Supervisor supervisor = new Supervisor(
                usuario,
                request.getNome(),
                request.getSobrenome(),
                request.getDataNascimento(),
                request.getSexo(),
                request.getEmail(),
                request.getDdd(),
                request.getNumeroTelefone()
        );

        return cadastrar((T) supervisor);
    }

    public T execute(CadastrarColaboradorRequest request) {
        Usuario usuario = cadastrarUsuario(request.getUsername(), request.getPassword(), request.getPerfilAcessoId());

        Colaborador colaborador = new Colaborador(
                usuario,
                request.getNome(),
                request.getSobrenome(),
                request.getDataNascimento(),
                request.getSexo(),
                request.getEmail(),
                request.getDdd(),
                request.getNumeroTelefone()
        );

        return cadastrar((T) colaborador);
    }

    private Usuario cadastrarUsuario(String username, String password, Long perfilAcessoId) {
        return cadastrarUsuarioUseCase.execute(username, password, perfilAcessoId);
    }


    public T cadastrar(T persona) {
        return repository.save(persona);
    }


}
