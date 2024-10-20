package com.nexcodelab.agendaclinicaser.application.gestaodesalas.controller.query;


import com.nexcodelab.agendaclinicaser.application.gestaodesalas.service.PainelDeSalasUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import com.nexcodelab.agendaclinicaser.shared.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class PainelDeSalasController {

    private final  PainelDeSalasUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/painel-salas/{dataReferencia}")
    public ResponseEntity<Void> execute(@PathVariable String dataReferencia){
        LocalDate dataReferenciaFormatada = DateUtils.toLocalDate(dataReferencia);

        service.execute(dataReferenciaFormatada);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
