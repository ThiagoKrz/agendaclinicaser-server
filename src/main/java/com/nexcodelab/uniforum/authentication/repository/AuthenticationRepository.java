package com.nexcodelab.uniforum.authentication.repository;

import com.nexcodelab.uniforum.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);

    Boolean existsByEmail(String email);
}
