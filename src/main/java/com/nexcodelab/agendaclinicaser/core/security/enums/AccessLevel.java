package com.nexcodelab.agendaclinicaser.core.security.enums;

import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;

import java.util.HashSet;
import java.util.Set;

public enum AccessLevel {
    ADMIN(new HashSet<>(Set.of(Role.ADMIN.name()))),
    CLINICA(new HashSet<>(Set.of(Role.ADMIN.name(), Role.RECEPCAO.name()))),

    SUPERVISOR(new HashSet<>(Set.of(Role.SUPERVISOR.name()))),
    ESTAGIARIO(new HashSet<>(Set.of(Role.ESTAGIARIO.name())));

    private final Set<String> roles;

    AccessLevel(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
