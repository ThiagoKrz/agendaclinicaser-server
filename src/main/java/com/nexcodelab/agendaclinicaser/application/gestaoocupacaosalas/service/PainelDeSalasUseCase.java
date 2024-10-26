package com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.service;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.repository.DisponibilidadeRepository;
import com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.dto.response.AgendaDiariaSalasResponse;
import com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.dto.response.SalaAgendaDiariaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PainelDeSalasUseCase {

    private DisponibilidadeRepository disponibilidadeRepository;

    public List<SalaAgendaDiariaResponse> execute(LocalDate dataReferencia)  {
    return List.of();
    }
}
''