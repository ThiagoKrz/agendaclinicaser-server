package com.nexcodelab.agendaclinicaser.application.user.persona.service;

import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import com.nexcodelab.agendaclinicaser.application.user.persona.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract  class CadastrarPersonaUseCase<T extends Persona> {

    @Autowired
    protected PersonaRepository<T> repository;

    public T execute (T persona) {
        return repository.save(persona);
    }
}
