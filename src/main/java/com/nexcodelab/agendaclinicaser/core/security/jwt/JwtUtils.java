package com.nexcodelab.agendaclinicaser.core.security.jwt;

import com.nexcodelab.agendaclinicaser.core.security.service.UserDetailsImpl;
import com.nexcodelab.agendaclinicaser.shared.utils.Validations;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.function.Function;

@Log4j2
@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;


    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return "Bearer " + Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String getUserNameFromJwtToken(String authToken) {
        return extractClaims(authToken, Claims::getSubject);
    }

    private <T> T extractClaims(String authToken, Function<Claims, T> claimsTFunction) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
        return claimsTFunction.apply(claims.getBody());
    }

    public String getJwtToken(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (!Validations.isEmpty(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }
}
