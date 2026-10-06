package com.tss.security_demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SecurityException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration}")
    private long jwtExpiration;

    private Key getSignedKey()
    {
        return Keys.hmacShaKeyFor(
                jwtSecret.getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generateToken(Authentication authentication)
    {
        CustomeUserDetails user = (CustomeUserDetails) authentication.getPrincipal();

        Date date = new Date();

        Date expiryDate = new Date(date.getTime() + jwtExpiration);

        List<String> roles = user.getAuthorities()
                .stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toList());

        return Jwts.builder()

                //storing username (email) as subject
                .subject(user.getUsername())
                .claim("roles", roles)
                .claim("userId", user.getUserId())
                .claim("jti", UUID.randomUUID().toString())
                .issuedAt(date)
                .expiration(expiryDate)
                .signWith(getSignedKey())
                .compact();

    }

    public Claims getClaims(String token)
    {
        return Jwts.parser()
                .verifyWith(
                        (SecretKeySpec) getSignedKey()
                )
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public UUID getUserId(String token) {
        String id = getClaims(token).get("userId", String.class);
        return UUID.fromString(id);
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    //for storing jti and expire at time for logout
    public String getJei(String token)
    {
        return getClaims(token).getId();
    }

    //to store expire time in table for expiration
    public LocalDateTime getExpiration(String token)
    {
        Date expiration = getClaims(token).getExpiration();

        return expiration
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
    public boolean validateToken(String token) {

        try {

            Jwts.parser()
                    .verifyWith(
                            (javax.crypto.SecretKey) getSignedKey()
                    )
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (
                SecurityException |
                MalformedJwtException |
                ExpiredJwtException |
                UnsupportedJwtException |
                IllegalArgumentException e
        ) {

            return false;
        }
    }

}
