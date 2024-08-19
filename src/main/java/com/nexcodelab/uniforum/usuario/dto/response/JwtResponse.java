package com.nexcodelab.uniforum.usuario.dto.response;

import com.nexcodelab.uniforum.shared.enums.TipoUsuario;
import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
	private String accessToken;
	private Long id;
	private String email;
    private TipoUsuario tipoUsuario;

	public JwtResponse(String accessToken, Long id, String email, TipoUsuario tipoUsuario) {
		this.accessToken = accessToken;
		this.id = id;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
	}
}
