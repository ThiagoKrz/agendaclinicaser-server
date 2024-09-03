package com.nexcodelab.agendaclinicaser.application.user.usuario.service;

import com.nexcodelab.agendaclinicaser.application.user.usuario.dto.request.LoginRequest;
import com.nexcodelab.agendaclinicaser.application.user.usuario.dto.response.JwtResponse;
import com.nexcodelab.agendaclinicaser.application.user.usuario.dto.response.LoggedUserResponse;
import com.nexcodelab.agendaclinicaser.application.user.usuario.repository.UsuarioRepository;
import com.nexcodelab.agendaclinicaser.core.security.jwt.JwtUtils;
import com.nexcodelab.agendaclinicaser.core.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginUseCase {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;


    public JwtResponse execute(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> permissoes = userDetails.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toList());

        JwtResponse jwtResponse = new JwtResponse(jwt, new LoggedUserResponse(userDetails.getId(), permissoes));

        return jwtResponse;
    }
}
