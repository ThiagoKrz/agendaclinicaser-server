package com.nexcodelab.agendaclinicaser.application.user.persona.repository;

import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository<T extends Persona> extends JpaRepository<T, String>  {

}
