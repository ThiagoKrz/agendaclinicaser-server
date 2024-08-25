package com.nexcodelab.agendaclinicaser.authentication.service;

import com.nexcodelab.agendaclinicaser.core.security.jwt.JwtUtils;
import com.nexcodelab.agendaclinicaser.core.security.service.UserDetailsImpl;
import com.nexcodelab.agendaclinicaser.authentication.dto.request.LoginRequest;
import com.nexcodelab.agendaclinicaser.authentication.dto.request.SignUpRequest;
import com.nexcodelab.agendaclinicaser.authentication.dto.response.JwtResponse;
import com.nexcodelab.agendaclinicaser.shared.enums.TipoUsuario;
import com.nexcodelab.agendaclinicaser.usuario.model.DadosPessoais;
import com.nexcodelab.agendaclinicaser.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.usuario.repository.DadosPessoaisRepository;
import com.nexcodelab.agendaclinicaser.authentication.repository.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationRepository authenticationRepository;
    private final DadosPessoaisRepository dadosPessoaisRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Transactional
    public void register (SignUpRequest request) {
        if (authenticationRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Error: Email is already taken!");
        }

        DadosPessoais dadosPessoais = dadosPessoaisRepository.save(
                new DadosPessoais(request.getNome(), request.getSobrenome(), request.getDataNascimento(), request.getSexo()));

        TipoUsuario tipoUsuario = request.getTipoUsuario() == null ? TipoUsuario.DISCENTE : request.getTipoUsuario();
        authenticationRepository.save(new Usuario(request.getEmail(), encoder.encode(request.getPassword()),dadosPessoais,  tipoUsuario));
    }


    public JwtResponse authenticate(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        TipoUsuario tipoUsuario = TipoUsuario.valueOf(userDetails.getAuthorities().stream().findFirst().get().getAuthority());

        JwtResponse jwtResponse = new JwtResponse(
                jwt,
                userDetails.getId(),
                userDetails.getNomeCompleto(),
                tipoUsuario
        );

        return jwtResponse;
    }

    public Boolean verifyEmailAvailable(String email) {
        return !authenticationRepository.existsByEmail(email);
    }

}
