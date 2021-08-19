package org.snetwork.config.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.Base64Codec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtProvider {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${jwt.validity}")
    private long tokenValidity;

    @Value("${jwt.secret}")
    private String secret;

    @PostConstruct
    private void encodeSecretKey() {
        this.secret = Base64Codec.BASE64.encode(secret);
    }

    public String generateToken(String username) {
        log.info("Generate a new token with {} subject", username);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidity))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            return !getClaims(token).getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException exception) {
            log.error("JwtResponse token is expired or invalid");
        }

        return false;
    }

    public Jws<Claims> getClaims(String token) throws JwtException {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }

    public long getExpirationDateTime(final String token) {
        return getClaims(token).getBody().getExpiration().getTime();
    }

    public String getToken(HttpServletRequest httpServletRequest) {
        return Optional.ofNullable(httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION))
                .map(value -> value.replaceFirst("Bearer", "").trim())
                .filter(StringUtils::hasLength)
                .orElse("");
    }

}
