package com.lubuwei2.ssm.security.jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/23.
 */

@Component
public class JwtGenerator {
    @Value("${jwt.secret}")
    private String secret;

    // 生成方法
    public String create() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jws = Jwts.builder()
                .setIssuer("cxb")
                .setSubject("Bob")
                .setAudience("you")
                .setExpiration(new Date())
                .setNotBefore(new Date())
                .setIssuedAt(new Date())
                .setId("1")
                .signWith(key).compact();

        return jws;
    }
}
