package com.nexcodelab.agendaclinicaser.application.user.estagiario.model;

import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import com.nexcodelab.agendaclinicaser.application.user.persona.model.Telefone;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.model.Supervisor;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Estagiario extends Persona {
    private Integer horasRequeridas;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Supervisor supervisor;

    public Estagiario(Usuario usuario, Integer horasRequeridas, String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, String ddd, String numero, Supervisor supervisor) {
        super(nome, sobrenome, dataNascimento, sexo, email, new Telefone(ddd, numero));
        this.usuario =  usuario;
        this.horasRequeridas = horasRequeridas;
        this.supervisor =  supervisor;
    }
}
