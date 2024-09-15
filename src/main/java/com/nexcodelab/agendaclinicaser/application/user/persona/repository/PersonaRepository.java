package com.nexcodelab.agendaclinicaser.application.user.persona.repository;

import com.nexcodelab.agendaclinicaser.application.user.persona.model.Persona;
import com.nexcodelab.agendaclinicaser.application.user.persona.vo.IPersonaResumidaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository<T extends Persona> extends JpaRepository<T, String>  {

    @Query("SELECT " +
           "   p.id AS id, " +
           "   CONCAT(p.nome, ' ', p.sobrenome) AS nomeCompleto, " +
           "   CONCAT(UPPER(SUBSTRING(p.nome, 1, 1)), UPPER(SUBSTRING(p.sobrenome, 1, 1))) AS sigla, " +
           "   NOT p.inativo AS isAtivo " +
           "FROM #{#entityName} p ")
    List<IPersonaResumidaVO> findAllPersonaResumida();
}
