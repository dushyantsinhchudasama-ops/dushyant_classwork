package com.tss.spring_security_app.security;

import com.tss.spring_security_app.exception.UserApiException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTTokenProvider {

    @Value("${app-jwt-secret}")
    private String secret;

    @Value("${app-jwt-expiration-milliseconds}")
    private Long jwtExpiration;

    public String generateToken(Authentication authentication)
    {
        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpiration);

        String token = Jwts.builder().claims().
                subject(username).issuedAt(currentDate).expiration(expireDate).and().signWith(key())


                // .claim("role", authentication.getAuthorities())

                .claim("role",
                        authentication.getAuthorities()
                                .stream()
                                .map(authority -> authority.getAuthority())
                                .toList())
                .compact();

        return token;
    }

    private SecretKey key()
    {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public boolean validateToken(String token)
    {
        try
        {
            Jwts.parser().verifyWith(key()).build().parseSignedClaims(token);
            return true;
        }
        catch (MalformedJwtException e)
        {
            throw new UserApiException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
        }
        catch (ExpiredJwtException e)
        {
            throw new UserApiException(HttpStatus.BAD_REQUEST, "Expired JWT token");
        }
        catch (UnsupportedJwtException e)
        {
            throw new UserApiException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
        }
        catch (IllegalArgumentException e)
        {
            throw new UserApiException(HttpStatus.BAD_REQUEST, "JWT claims string is empty");
        }
        catch (Exception e)
        {
            throw new UserApiException(HttpStatus.BAD_REQUEST, "Invalid Credentials");
        }
    }


    public String getUserName(String token)
    {
        Claims claims = Jwts.parser().verifyWith(key()).build().parseSignedClaims(token).getPayload();

        String username = claims.getSubject();

        return username;
    }
}
