package com.nexcodelab.agendaclinicaser.comentario.model;

import com.nexcodelab.agendaclinicaser.core.model.EntidadeBase;
import com.nexcodelab.agendaclinicaser.curtida.model.CurtidaComentario;
import com.nexcodelab.agendaclinicaser.topico.model.Topico;
import com.nexcodelab.agendaclinicaser.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Comentario extends EntidadeBase{
    @Lob
    private String conteudo;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer qtdCurtidas;

    @ManyToOne(fetch = FetchType.LAZY)
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "comentario_id")
    private List<CurtidaComentario> curtidas;
}


