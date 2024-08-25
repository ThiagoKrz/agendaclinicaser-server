package com.nexcodelab.agendaclinicaser.topico.service;

import com.nexcodelab.agendaclinicaser.topico.dto.request.CreateTopicoRequest;
import com.nexcodelab.agendaclinicaser.topico.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTopicoUseCase {

    private final TopicoRepository topicoRepository;

    public void execute(CreateTopicoRequest request, Long idUsuarioLogado){
    }

}
