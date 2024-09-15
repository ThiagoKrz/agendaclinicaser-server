package com.nexcodelab.agendaclinicaser.application.sala.service;

import com.nexcodelab.agendaclinicaser.application.sala.repository.SalaRepository;
import com.nexcodelab.agendaclinicaser.application.sala.vo.ISalaResumidaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarSalaUseCase {

    private final SalaRepository repository;

    public List<ISalaResumidaVO> execute(){
        return repository.findAllSalaResumida();
    }
}
