package com.nexcodelab.agendaclinicaser.application.user.estagiario.service;

import com.nexcodelab.agendaclinicaser.application.user.estagiario.dto.response.DetalhesEstagiarioResponse;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.model.Estagiario;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.repository.EstagiarioRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarEstagiarioUseCase {

    private final EstagiarioRepository repository;

    public DetalhesEstagiarioResponse execute(String id) {
        Estagiario estagiario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estagiário não encontrado"));

        return toDetalhesEstagiarioResponse(estagiario);
    }
    public DetalhesEstagiarioResponse toDetalhesEstagiarioResponse(Estagiario estagiario) {
        return DetalhesEstagiarioResponse.builder()
                .periodo(estagiario.getPeriodo())
                .horasRequeridas(estagiario.getHorasRequeridas())
                .nomeCompletoSupervisor(estagiario.getNomeCompletoSupervisor())
                .id(estagiario.getId())
                .nome(estagiario.getNome())
                .sobrenome(estagiario.getSobrenome())
                .email(estagiario.getEmail())
                .telefone(estagiario.getTelefone().getNumeroTelefone())
                .build();
    }

}
