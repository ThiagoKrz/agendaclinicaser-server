package com.nexcodelab.agendaclinicaser.application.sala.controller.command;

import com.nexcodelab.agendaclinicaser.application.sala.dto.request.CadastrarSalaRequest;
import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.application.sala.repository.SalaRepository;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@RequiredArgsConstructor
public class CadastrarSalaController {

    private final SalaRepository salaRepository;

    @RolesAllowed(accessLevel = AccessLevel.ADMIN)
    @PostMapping("/sala")
    public ResponseEntity<Void> execute(@RequestBody CadastrarSalaRequest request){

        Sala sala = new Sala(request.getNome());

        salaRepository.save(sala);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
