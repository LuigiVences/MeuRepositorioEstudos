package com.luizvenceslau.PaeseWeb.security.jwt;

import java.time.Instant;
import java.util.stream.Collectors;

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
        String scopes = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(""));
        var claims = JwtClaimsSet.builder()
                .issuer("PaeseWeb")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(EXPIRATION))
                .subject(authentication.getName())
                .claim("scope", scopes)
                .build();
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }




}
