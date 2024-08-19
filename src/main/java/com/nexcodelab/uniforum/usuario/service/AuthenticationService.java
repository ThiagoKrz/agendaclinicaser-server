package com.nexcodelab.uniforum.usuario.service;

import com.nexcodelab.uniforum.core.security.jwt.JwtUtils;
import com.nexcodelab.uniforum.core.security.service.UserDetailsImpl;
import com.nexcodelab.uniforum.usuario.dto.request.LoginRequest;
import com.nexcodelab.uniforum.usuario.dto.request.SignUpRequest;
import com.nexcodelab.uniforum.usuario.dto.response.JwtResponse;
import com.nexcodelab.uniforum.shared.enums.TipoUsuario;
import com.nexcodelab.uniforum.usuario.model.Usuario;
import com.nexcodelab.uniforum.usuario.repository.UsuarioRepository;
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

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Transactional
    public void register (SignUpRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Error: Email is already taken!");
        }

        TipoUsuario tipoUsuario = request.getTipoUsuario() == null ? TipoUsuario.DISCENTE : request.getTipoUsuario();
        Usuario user = new Usuario( request.getEmail(), encoder.encode(request.getPassword()),  tipoUsuario);

        usuarioRepository.save(user);
    }


    public JwtResponse authenticate(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = "Bearer " + jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        TipoUsuario tipoUsuario = TipoUsuario.valueOf(userDetails.getAuthorities().stream().findFirst().get().getAuthority());

        JwtResponse jwtResponse = new JwtResponse(
               jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                tipoUsuario
        );

        return jwtResponse;
    }
}
