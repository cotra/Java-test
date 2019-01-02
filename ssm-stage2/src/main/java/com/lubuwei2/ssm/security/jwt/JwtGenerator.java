package com.lubuwei2.ssm.security.jwt;

import com.lubuwei2.ssm.utils.TimeUtils;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/23.
 */

@Component
public class JwtGenerator {

    @Value("${jwt.iss}")
    private String iss;

    @Value("${jwt.exp}")
    private String exp;

    // 随机key
    private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 生成jws
    public String create(String aud, Date iat) {
        String jws = Jwts.builder()
                .setIssuer(iss)
                .setAudience(aud)
                .setExpiration(TimeUtils.addMonths(Integer.parseInt(exp)))
                .setIssuedAt(iat)
                .signWith(key).compact();
        return jws;
    }

    // 读取
    public Jws<Claims> read(String jws) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jws);
            return claimsJws;
        } catch (JwtException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
