package com.nexcodelab.uniforum.usuario.model;

import com.nexcodelab.uniforum.core.model.EntidadeBase;
import com.nexcodelab.uniforum.shared.enums.Curso;
import com.nexcodelab.uniforum.shared.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Usuario extends EntidadeBase{
    @Column(length = 45, nullable = false)
    private String email;

    @Column(length = 90, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    private Integer periodo;

    @OneToOne
    @JoinColumn(name = "dados_pessoais_id")
    private DadosPessoais dadosPessoais;

    private TipoUsuario tipoUsuario;


    public Usuario(String email, String password, TipoUsuario tipoUsuario) {
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

}
