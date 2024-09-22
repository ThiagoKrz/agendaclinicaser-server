package com.nexcodelab.agendaclinicaser.application.user.colaborador.service;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.response.DetalhesColaboradorResponse;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.repository.ColaboradorRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarColaboradorUseCase {

    private final ColaboradorRepository repository;

    public DetalhesColaboradorResponse execute(String id) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Colaborador não encontrado"));

        return toDetalhesColaboradorResponse(colaborador);
    }
    public DetalhesColaboradorResponse toDetalhesColaboradorResponse(Colaborador colaborador) {
        return DetalhesColaboradorResponse.builder()
                .id(colaborador.getId())
                .nome(colaborador.getNome())
                .sobrenome(colaborador.getSobrenome())
                .email(colaborador.getEmail())
                .telefone(colaborador.getTelefone().getNumeroTelefone())
                .build();
    }

}
