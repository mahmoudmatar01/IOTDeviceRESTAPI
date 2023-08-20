package com.example.IOTproject.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class TokenUtil {
    private final String claims_subject="sub";
    private final String claims_created="created";
    private Long token_validity=604800L;
    private String Token_Secrete="toDoApiSecrete";
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(claims_subject,userDetails.getUsername());
        claims.put(claims_created,new Date());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.ES512,Token_Secrete)
                .compact();
    }

    private Date generateExpirationDate() {
        return new Date((System.currentTimeMillis()+token_validity*1000));
    }

    public String getUserNameFromToken(String token) {
        try {
            Claims claims=getClaims(token);
            return claims.getSubject();
        }catch (Exception ex){
            return null;
        }
    }

    private Claims getClaims(String token) {
        Claims claims;
        try {
            claims=Jwts.parser().setSigningKey(Token_Secrete)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception ex){
            claims=null;
        }
        return claims;
    }

    public boolean isTokenValid(String token ,UserDetails userDetails){
        String username=getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expiration =getClaims(token).getExpiration();
        return expiration.before(new Date());
    }
}
