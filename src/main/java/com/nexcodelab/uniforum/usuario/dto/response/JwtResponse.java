package com.nexcodelab.uniforum.usuario.dto.response;

import com.nexcodelab.uniforum.shared.enums.TipoUsuario;
import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
	private String accessToken;
	private LoggedUserResponse user;

	public JwtResponse(String accessToken, Long id, String nomeCompleto, TipoUsuario tipoUsuario) {
		this.accessToken = accessToken;
		this.user = new LoggedUserResponse(id, nomeCompleto, tipoUsuario);
	}
}
