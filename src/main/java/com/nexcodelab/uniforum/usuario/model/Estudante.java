package com.nexcodelab.uniforum.usuario.model;

import com.nexcodelab.uniforum.core.model.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Inheritance
@Data
@NoArgsConstructor
public class Estudante extends Usuario {
    @Column(length = 45, nullable = false)
    private String curso;

    @Column(length = 45, nullable = false)
    private Integer periodo;
}
