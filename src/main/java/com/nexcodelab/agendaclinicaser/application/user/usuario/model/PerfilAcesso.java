package com.nexcodelab.agendaclinicaser.application.user.usuario.model;

import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class PerfilAcesso extends EntityBase {
    @Column(length = 90, nullable = false)
    String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "perfil_acesso_permissoes",
            joinColumns = @JoinColumn(name = "perfil_acesso_id"),
            inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private Set<Permissao> permissoes = new HashSet<>();
}
