package com.luizvenceslau.PaeseWeb.security.jwt;

import java.util.function.Function;

import com.luizvenceslau.PaeseWeb.security.MyCustomUserDetails;

@Service
public class JwtService {

    @Value("${security.jwt.secret}")
    private String SECRET_KEY;

    @Value("${security.jwt.expiration-ms}")
    private Long EXPIRATION_TIME;

    private key getSigningKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = Jwts.parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parserClaimsJws(token)
        .getBody();
        return claimsResolver.apply(claims);
    }

    public String generateToken(MyCustomUserDetails myCustomUserDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, myCustomUserDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.buider()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

}
