package com.nexcodelab.uniforum.usuario.repository;

import com.nexcodelab.uniforum.usuario.model.DadosPessoais;
import com.nexcodelab.uniforum.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Integer> {
}
