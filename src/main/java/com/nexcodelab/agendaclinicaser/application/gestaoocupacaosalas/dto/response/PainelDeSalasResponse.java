package com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.dto.response;

import com.nexcodelab.agendaclinicaser.application.atendimento.model.Atendimento;
import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.application.sala.vo.ISalaResumidaVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@AllArgsConstructor
public class PainelDeSalasResponse {
    DayOfWeek diaDaSemana;
    List<PainelDeSalasHorarioResponse> horarios;

    public static PainelDeSalasResponse of(DayOfWeek diaDaSemana, List<ISalaResumidaVO> salasVO) {
        List<PainelDeSalasHorarioResponse> horarios = IntStream.rangeClosed(7, 18)
                .mapToObj(hora -> PainelDeSalasHorarioResponse.of(LocalTime.of(hora, 0), salasVO))
                .collect(Collectors.toList());

        return new PainelDeSalasResponse(diaDaSemana, horarios);
    }

    @AllArgsConstructor
    @Getter
    public static class PainelDeSalasHorarioResponse {
        LocalTime horario;
        List<PainelDeSalasSalaResponse> salas;

        public static PainelDeSalasHorarioResponse of(LocalTime horario, List<ISalaResumidaVO> salasVO) {
            List<PainelDeSalasSalaResponse> salas = salasVO.stream()
                    .map(vo -> PainelDeSalasSalaResponse.of(vo.getId(), vo.getNome()))
                    .collect(Collectors.toList());

            return new PainelDeSalasHorarioResponse(horario, salas);
        }

        public void adicionarOcupacao(String idEstagiario, String nomeEstagiario, Sala sala) {
            PainelDeSalasSalaResponse salaPainel = salas.stream().filter(s -> s.idSala.equals(sala.getId())).findFirst().get();

            if(salaPainel != null) {
                salaPainel.adicionarOcupacao(idEstagiario, nomeEstagiario);
            }
        }

        public void adicionarAtendimento(Atendimento atendimento) {
            PainelDeSalasSalaResponse salaPainel = salas.stream().filter(s -> s.idSala.equals(atendimento.getLocalDeTerapia().getSala().getId())).findFirst().get();

            if(salaPainel != null) {
                salaPainel.adicionarAtendimento(atendimento);
            }
        }

    }


    @RequiredArgsConstructor
    @Getter
    public static class PainelDeSalasSalaResponse {
        @NonNull String idSala;
        @NonNull String nomeSala;

        // Ocupacao
        String idEstagiario;
        String nomeEstagiario;


        // Atendimento
        String nomePaciente;
//        String nomeSupervisor;

        public static PainelDeSalasSalaResponse of(String idSala, String nomeSala) {
            return new PainelDeSalasSalaResponse(idSala, nomeSala);
        }

        public void adicionarOcupacao(String idEstagiario, String nomeEstagiario) {
            this.nomeEstagiario = nomeEstagiario;
            this.idEstagiario = idEstagiario;
        }

        public void adicionarAtendimento(Atendimento atendimento) {
            this.nomePaciente = atendimento.getPacienteEmServico().getPaciente().getNomeCompleto();
        }
    }
}
