package com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model;


import com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model.interfaces.IAgendavel;
import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.model.Estagiario;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@NoArgsConstructor

public abstract class OcupacaoHorario extends EntityBase {

    private TipoOcupacaoHorario tipoOcupacao;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;


    @Any(metaColumn = @Column(name = "agendavel_type"))
    @AnyMetaDef(idType = "string", metaType = "string", metaValues = {
            @MetaValue(targetEntity = Estagiario.class, value = "E"),
            @MetaValue(targetEntity = Paciente.class, value = "P"),
            @MetaValue(targetEntity = Sala.class, value = "SP"),
    })
    @JoinColumn(name = "agendavel_id")
    private IAgendavel agendavel;
}
