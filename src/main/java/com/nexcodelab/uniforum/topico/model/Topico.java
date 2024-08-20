package com.nexcodelab.uniforum.topico.model;

import com.nexcodelab.uniforum.comentario.model.Comentario;
import com.nexcodelab.uniforum.core.model.EntidadeBase;
import com.nexcodelab.uniforum.curtida.model.CurtidaTopico;
import com.nexcodelab.uniforum.shared.enums.Curso;
import com.nexcodelab.uniforum.shared.enums.Tag;
import com.nexcodelab.uniforum.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Topico extends EntidadeBase{
    @Column(nullable = false)
    private String titulo;

    @Lob
    private String conteudo;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Enumerated(EnumType.STRING)
    private Tag tag;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer qtdCurtidas;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer qtdComentarios;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "topico_id")
    private List<CurtidaTopico> curtidas;
}
