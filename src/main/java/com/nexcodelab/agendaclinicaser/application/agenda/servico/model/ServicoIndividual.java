//package com.nexcodelab.agendaclinicaser.application.agenda.servico.model;
//
//import com.nexcodelab.agendaclinicaser.application.agenda.atendimento.model.EstagiarioEmServico;
//import com.nexcodelab.agendaclinicaser.application.agenda.atendimento.model.LocalDeTerapia;
//import com.nexcodelab.agendaclinicaser.application.agenda.atendimento.model.PacienteEmServico;
//import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
//import jakarta.persistence.Entity;
//import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.CascadeType;
//import javax.persistence.OneToOne;
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@NoArgsConstructor
//public class ServicoIndividual extends EntityBase {
//    @Getter @OneToOne(cascade = CascadeType.ALL) private PacienteEmServico pacienteEmServico;
//    @Getter @OneToOne(cascade = CascadeType.ALL) private EstagiarioEmServico estagiarioEmServico;
//    @OneToOne(cascade = CascadeType.ALL) private LocalDeTerapia localDeTerapia;
//
//    @NotNull private LocalDateTime dataHoraInicio;
//    @NotNull private LocalDateTime dataHoraFim;
//}
