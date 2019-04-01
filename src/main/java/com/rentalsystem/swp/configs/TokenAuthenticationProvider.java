package com.rentalsystem.swp.configs;

import com.google.common.collect.Iterables;
import com.rentalsystem.swp.models.UserProfileDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class TokenAuthenticationProvider {

    @Value("${jwt.secret}")
    private String tokenSecret;
    @Value("${jwt.expiration}")
    private Long tokenExpiration;

    public String createToken(Authentication authentication) {
        UserProfileDetails userPrincipal = (UserProfileDetails) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + tokenExpiration);

        return Jwts.builder()
                .claim("id", userPrincipal.getId())
                .setSubject(userPrincipal.getUsername())
                .claim("role", Iterables.getOnlyElement(userPrincipal.getAuthorities()).getAuthority())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, tokenSecret)
                .compact();
    }

    String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(tokenSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            log.warn("Invalid JWT signature", ex);
        } catch (MalformedJwtException ex) {
            log.warn("Invalid JWT token", ex);
        } catch (ExpiredJwtException ex) {
            log.warn("Expired JWT token", ex);
        } catch (UnsupportedJwtException ex) {
            log.warn("Unsupported JWT token", ex);
        } catch (IllegalArgumentException ex) {
            log.warn("JWT claims string is empty", ex);
        }
        return false;
    }
}