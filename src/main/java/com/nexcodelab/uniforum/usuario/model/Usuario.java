package com.nexcodelab.uniforum.usuario.model;

import com.nexcodelab.uniforum.comentario.model.Comentario;
import com.nexcodelab.uniforum.core.model.EntidadeBase;
import com.nexcodelab.uniforum.shared.enums.Curso;
import com.nexcodelab.uniforum.shared.enums.TipoUsuario;
import com.nexcodelab.uniforum.topico.model.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
@SQLDelete(sql = "UPDATE Usuario SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
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

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Topico> topicos;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "topico_id")
    private List<Comentario> comentarios;

    private Boolean deleted = Boolean.FALSE;


    public Usuario(String email, String password, DadosPessoais dadosPessoais, TipoUsuario tipoUsuario) {
        this.email = email;
        this.password = password;
        this.dadosPessoais = dadosPessoais;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNomeCompleto(){
        return this.dadosPessoais.getNome() + " " + this.dadosPessoais.getSobrenome();
    }

}
