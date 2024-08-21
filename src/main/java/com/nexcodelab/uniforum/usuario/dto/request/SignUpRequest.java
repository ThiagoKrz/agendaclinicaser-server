package com.nexcodelab.uniforum.usuario.dto.request;

import com.nexcodelab.uniforum.shared.enums.Sexo;
import com.nexcodelab.uniforum.shared.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.time.LocalDate;

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

	@NotNull
	@Size(max = 45)
	String nome;

	@NotNull
	@Size(max = 45)
	String sobrenome;

	@NotNull
	LocalDate dataNascimento;

	@NotNull
	Sexo sexo;
}
