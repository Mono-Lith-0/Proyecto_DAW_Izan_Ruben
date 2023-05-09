/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.security;

import daw.proyecto.back.model.Autor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author Izan Lorenzo
 */
@Service
public class JwtService {
    
    private static final String secret = "3273357638792F423F4528482B4D6251655468576D5A7133743677397A244326";
    
    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }
    
    public long getUserId(String token) {
        return Long.parseLong(getAllClaims(token).get("userId").toString());
    }
    
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    public String generateToken(Autor autor) {
        Map<String, Object> claim = new HashMap<>();
        claim.put("userId", autor.getId());
        return generateToken(claim, autor);
    }
    
    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(generateExpirationDate())
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    public Claims getAllClaims(String token) throws ExpiredJwtException {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBites = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBites);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }
    
    private Date generateExpirationDate() {
        
        LocalDateTime lct = LocalDateTime.now().plusDays(1);
        
        return Date.from(lct.atZone(ZoneId.systemDefault()).toInstant());
    }
}

