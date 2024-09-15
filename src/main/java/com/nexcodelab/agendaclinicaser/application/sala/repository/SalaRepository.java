package com.nexcodelab.agendaclinicaser.application.sala.repository;

import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.application.sala.vo.ISalaResumidaVO;
import com.nexcodelab.agendaclinicaser.application.user.persona.vo.IPersonaResumidaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    @Query("SELECT  s.id AS id, s.nome AS nome FROM Sala s")
    List<ISalaResumidaVO> findAllSalaResumida();
}
