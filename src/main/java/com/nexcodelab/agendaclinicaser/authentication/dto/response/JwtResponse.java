package com.nexcodelab.agendaclinicaser.authentication.dto.response;

import com.nexcodelab.agendaclinicaser.shared.enums.TipoUsuario;
import lombok.Data;

@Data
public class JwtResponse {
	private String accessToken;
	private LoggedUserResponse user;

	public JwtResponse(String accessToken, Long id, String nomeCompleto, TipoUsuario tipoUsuario) {
		this.accessToken = accessToken;
		this.user = new LoggedUserResponse(id, nomeCompleto, tipoUsuario);
	}
}
