package com.luizvenceslau.PaeseWeb.security.jwt;

import java.time.Instant;
import java.util.stream.Collectors;

import com.luizvenceslau.PaeseWeb.security.UserAuthenticated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;


@Service
public class JwtService {


 /*

    Classe não será usada pois a authenticação nao vai ser com jwt

    private final JwtEncoder encoder;
    private final JwtDecoder decoder;

    @Value("${EXPIRATION}")
    private Long EXPIRATION;

    public JwtService(JwtEncoder encoder, JwtDecoder decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    public String generateToken(Authentication authentication){

        Instant now = Instant.now();
        var user = (UserAuthenticated) authentication.getPrincipal();

        String roles = user.getAuthorities().stream()
            .filter(auth -> auth.getAuthority().startsWith("ROLE_"))
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" "));

        String privileges = user.getAuthorities().stream()
            .filter(auth -> !auth.getAuthority().startsWith("ROLE_"))
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("PaeseWeb")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(EXPIRATION))
                .subject(authentication.getName())
                .claim("roles", roles)
                .claim("privileges", privileges)
                .build();
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    */


}
