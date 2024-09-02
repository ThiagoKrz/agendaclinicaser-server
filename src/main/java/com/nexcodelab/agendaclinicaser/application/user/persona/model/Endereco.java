package com.nexcodelab.agendaclinicaser.application.user.persona.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Endereco {
	private String cep;
	private String pais;
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String numeroResidencia;
	private String complemento;
}
