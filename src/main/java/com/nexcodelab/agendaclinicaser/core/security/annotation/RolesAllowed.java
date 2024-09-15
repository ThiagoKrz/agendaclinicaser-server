package com.nexcodelab.agendaclinicaser.core.security.annotation;

import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RolesAllowed {
    AccessLevel accessLevel();
}
