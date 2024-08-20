package com.nexcodelab.uniforum.curtida.model;

import com.nexcodelab.uniforum.comentario.model.Comentario;
import com.nexcodelab.uniforum.core.model.EntidadeBase;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor @AllArgsConstructor
public abstract class Curtida extends EntidadeBase{
    @Column(nullable = false)
    private String titulo;

    private Long usuario_id;
}
