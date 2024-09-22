package com.nexcodelab.agendaclinicaser.application.user.persona.service;

import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import com.nexcodelab.agendaclinicaser.application.user.persona.repository.PersonaRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Component
public abstract class PersonaService<T extends Persona> {

    @Autowired
    protected PersonaRepository<T> repository;


    @Transactional
    public T cadastrar(T persona) {
        return repository.save(persona);
    }

    @Transactional
    public void ativarInativar (String id) {
        T persona  = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persona não encontrada"));
        persona.ativarInativar();
    }
}
