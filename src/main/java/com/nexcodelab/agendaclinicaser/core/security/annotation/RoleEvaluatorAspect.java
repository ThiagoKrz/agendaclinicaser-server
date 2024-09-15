package com.nexcodelab.agendaclinicaser.core.security.annotation;

import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class RoleEvaluatorAspect {

    @Before("@annotation(rolesAllowed)")
    public void evaluateRoles(RolesAllowed rolesAllowed) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Role[] roles = rolesAllowed.roles();

        for (Role role : roles) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority(role.name()))) {
                return;
            }
        }

        throw new SecurityException();
    }
}
