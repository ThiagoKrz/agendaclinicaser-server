package com.nexcodelab.uniforum.usuario.dto.request;

import com.nexcodelab.uniforum.shared.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class SignUpRequest {
	
	@NotNull
	@Size(max = 45)
	@Email
	String email;
	
	@NotNull
	@Size(min= 6, max = 45)
	String password;

	@NotNull
	TipoUsuario tipoUsuario;
}
