package com.nexcodelab.agendaclinicaser.authentication.dto.response;

import com.nexcodelab.agendaclinicaser.shared.enums.TipoUsuario;
import lombok.Data;

@Data
public class LoggedUserResponse {
	private Long id;
	private String nomeCompleto;
    private TipoUsuario tipoUsuario;

	public LoggedUserResponse(Long id, String nomeCompleto, TipoUsuario tipoUsuario) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.tipoUsuario = tipoUsuario;
	}
}
