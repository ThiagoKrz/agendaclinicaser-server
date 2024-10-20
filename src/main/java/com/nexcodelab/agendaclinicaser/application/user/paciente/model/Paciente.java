package com.nexcodelab.agendaclinicaser.application.user.paciente.model;

import com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model.interfaces.IAgendavel;
import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import com.nexcodelab.agendaclinicaser.application.user.persona.model.Telefone;
import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Paciente extends Persona implements IAgendavel {

    public Paciente(String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, String ddd, String numeroTelefone) {
        super(nome, sobrenome, dataNascimento, sexo, email, new Telefone(ddd, numeroTelefone));
    }
}
