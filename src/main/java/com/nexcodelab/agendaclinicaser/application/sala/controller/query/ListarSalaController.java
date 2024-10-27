package com.nexcodelab.agendaclinicaser.application.sala.controller.query;

import com.nexcodelab.agendaclinicaser.application.sala.service.ListarSalaUseCase;
import com.nexcodelab.agendaclinicaser.application.sala.vo.ISalaResumidaVO;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Sala")
@RestController
@RequiredArgsConstructor
public class ListarSalaController {

    private final ListarSalaUseCase service;

    @Operation(summary = "Listar sala")
    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/sala")
    public ResponseEntity<List<ISalaResumidaVO>> execute(){
        return ResponseEntity.ok(service.execute());
    }
}
