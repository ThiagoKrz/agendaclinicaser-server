package com.nexcodelab.agendaclinicaser.application.user.colaborador.model;

import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import com.nexcodelab.agendaclinicaser.application.user.persona.model.Telefone;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Colaborador extends Persona {

    public Colaborador(Usuario usuario, String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, String ddd, String numero) {
        super(nome, sobrenome, dataNascimento, sexo, email, new Telefone(ddd, numero), usuario);
    }
}
