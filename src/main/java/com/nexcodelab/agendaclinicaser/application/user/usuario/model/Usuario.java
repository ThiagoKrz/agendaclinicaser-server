package com.nexcodelab.agendaclinicaser.application.user.usuario.model;

import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Usuario extends EntityBase {
    @Column(length = 90, nullable = false)
    private String username;

    @Column(length = 90, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    Role role;

    private Boolean primeiroAcesso = true;
}
