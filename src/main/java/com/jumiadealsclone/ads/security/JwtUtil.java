package com.jumiadealsclone.ads.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import java.security.*;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "294A404E635266556A586E327235753778214125442A472D4B6150645367566B";
    private Key signInKey;

    public String extractUsername(String token) throws NoSuchAlgorithmException {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) throws NoSuchAlgorithmException {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws NoSuchAlgorithmException {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) throws NoSuchAlgorithmException {
        return Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() throws NoSuchAlgorithmException {
        /*If you're using Spring Boot, you can generate a signing
        key using the Mac class from the javax.crypto package.
        Here's an example of how you can modify your code to generate a signing key using Mac:
        In this example, we're using the KeyGenerator class to generate a secure key using the
         HmacSHA256 algorithm. We're also using a SecureRandom object initialized with the
         base64-decoded SECRET_KEY to generate the key, which helps ensure that the key is truly random.
         Once the key is generated, we can use it to initialize a Mac object, which we can then use to
         sign and verify messages.
        */
        if(signInKey == null){
            byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecureRandom secureRandom = new SecureRandom(keyBytes);
            keyGenerator.init(secureRandom);
            signInKey = keyGenerator.generateKey();
        }

        return signInKey;
    }

    private Boolean isTokenExpired(String token) throws NoSuchAlgorithmException {
        return extractExpiration(token).before(new Date());
    }

    public Boolean isTokenValid(String token, UserDetails userDetails) throws NoSuchAlgorithmException {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public String generateToken(UserDetails userDetails) throws NoSuchAlgorithmException {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) throws NoSuchAlgorithmException {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(SignatureAlgorithm.HS256,getSignInKey())
                .compact();
    }
}