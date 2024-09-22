package com.nexcodelab.agendaclinicaser.application.user.supervisor.model;

import com.nexcodelab.agendaclinicaser.application.user.estagiario.model.Estagiario;
import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import com.nexcodelab.agendaclinicaser.application.user.persona.model.Telefone;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Supervisor extends Persona {

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Estagiario> estagiarios;

    public Supervisor(Usuario usuario, String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, String ddd, String numero) {
        super(nome, sobrenome, dataNascimento, sexo, email, new Telefone(ddd, numero), usuario);
    }
}
