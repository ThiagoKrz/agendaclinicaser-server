package com.nexcodelab.agendaclinicaser.application.sala.controller;

import com.nexcodelab.agendaclinicaser.application.sala.service.ListarSalaUseCase;
import com.nexcodelab.agendaclinicaser.application.sala.vo.ISalaResumidaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarSalaController {

    private final ListarSalaUseCase service;

    @GetMapping("/sala")
    private ResponseEntity<List<ISalaResumidaVO>> execute(){
        return ResponseEntity.ok(service.execute());
    }
}
