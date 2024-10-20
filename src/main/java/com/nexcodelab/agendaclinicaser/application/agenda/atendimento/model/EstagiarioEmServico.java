//package com.nexcodelab.agendaclinicaser.application.agenda.atendimento.model;
//
//import com.nexcodelab.agendaclinicaser.application.agenda.servico.model.ServicoIndividual;
//import com.nexcodelab.agendaclinicaser.application.user.estagiario.model.Estagiario;
//import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
//import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@NoArgsConstructor
//public class EstagiarioEmServico extends EntityBase {
//    @ManyToOne @NotNull private Estagiario estagiario;
//
//    @NotNull @OneToOne(mappedBy = "estagiarioEmServico") private ServicoIndividual servico;
//
//    @Enumerated(EnumType.STRING) @Setter
//    private ComparecimentoEnvolvido comparecimentoEnvolvido;
//}
