package com.nexcodelab.agendaclinicaser.application.agenda.estagiario.controller.query;

import com.nexcodelab.agendaclinicaser.application.agenda.estagiario.dto.response.AtendimentoAgendaEstagiarioResponse;
import com.nexcodelab.agendaclinicaser.application.agenda.estagiario.service.AgendaEstagiarioUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import com.nexcodelab.agendaclinicaser.shared.utils.DateUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Tag(name = "Agenda")
@RestController
@RequiredArgsConstructor
public class AgendaEstagiarioController {

    private final AgendaEstagiarioUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/agenda-estagiario/{dataReferencia}")
    public ResponseEntity<List<AtendimentoAgendaEstagiarioResponse>> execute(@PathVariable String dataReferencia){


        List<AtendimentoAgendaEstagiarioResponse> response = service.execute(dataReferencia);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
