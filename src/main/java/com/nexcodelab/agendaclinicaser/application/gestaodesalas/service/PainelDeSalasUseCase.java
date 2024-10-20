package com.nexcodelab.agendaclinicaser.application.gestaodesalas.service;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.repository.DisponibilidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PainelDeSalasUseCase {

    private DisponibilidadeRepository disponibilidadeRepository;

    public void execute(LocalDate dataReferencia)  {

    }
}
