package com.nexcodelab.uniforum.authentication.dto.response;

import com.nexcodelab.uniforum.shared.enums.TipoUsuario;
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
