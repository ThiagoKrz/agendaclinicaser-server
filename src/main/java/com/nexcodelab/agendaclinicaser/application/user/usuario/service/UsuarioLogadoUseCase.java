package com.nexcodelab.agendaclinicaser.application.user.usuario.service;

import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import com.nexcodelab.agendaclinicaser.application.user.persona.repository.PersonaRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.BadRequestRestException;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import com.nexcodelab.agendaclinicaser.core.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioLogadoUseCase<T extends Persona> {
    private final PersonaRepository<T> personaRepository;

    public T getPersonaLogada(Class<T> clazz){
        return personaRepository.findPersonaLogada(getIdUsuarioLogado()).orElseThrow(() -> new ResourceNotFoundException("Acesso negado"));
    }

    public Long getIdUsuarioLogado() {
        return ((UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getId();
    }
}
