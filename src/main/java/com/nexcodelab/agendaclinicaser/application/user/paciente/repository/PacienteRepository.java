package com.nexcodelab.agendaclinicaser.application.user.paciente.repository;

import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.application.user.paciente.vo.IPacienteParaListagemVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

    @Query("SELECT p.id AS id,  CONCAT(p.nome, ' ', p.sobrenome) AS nomeCompleto, NOT p.inativo AS isAtivo FROM Paciente p")
    List<IPacienteParaListagemVO> listarPacientes();

}
