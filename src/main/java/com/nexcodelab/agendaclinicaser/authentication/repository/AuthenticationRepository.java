package com.nexcodelab.agendaclinicaser.authentication.repository;

import com.nexcodelab.agendaclinicaser.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    Boolean existsByEmail(String email);
}
