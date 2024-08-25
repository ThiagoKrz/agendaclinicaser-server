package com.nexcodelab.agendaclinicaser.usuario.repository;

import com.nexcodelab.agendaclinicaser.usuario.model.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Integer> {
}
