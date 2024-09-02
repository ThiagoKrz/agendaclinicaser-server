package com.nexcodelab.agendaclinicaser.application.user.usuario.model;

import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Usuario extends EntityBase {
    @Column(length = 90, nullable = false)
    private String username;

    @Column(length = 90, nullable = false)
    private String password;

    @ManyToOne
    private PerfilAcesso perfilAcesso;

    private Boolean primeiroAcesso = true;
}
