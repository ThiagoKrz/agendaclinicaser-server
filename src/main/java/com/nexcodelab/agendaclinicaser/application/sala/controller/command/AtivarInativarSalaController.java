package com.nexcodelab.agendaclinicaser.application.sala.controller.command;

import com.nexcodelab.agendaclinicaser.application.sala.service.AtivarInativarSalaUseCase;
import com.nexcodelab.agendaclinicaser.application.sala.vo.ISalaResumidaVO;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AtivarInativarSalaController {

    private final AtivarInativarSalaUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @PatchMapping("/sala/ativar-inativar/{id}")
    public ResponseEntity<List<ISalaResumidaVO>> execute(@PathVariable String id){
        service.execute(id);

        return ResponseEntity.noContent().build();
    }
}
