package com.lubuwei2.ssm.security.jwt;

import com.lubuwei2.ssm.utils.TimeUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/23.
 */

public class JwtGenerator {

    // 随机key
    private static SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 生成jws
    public static String create() {
        String jws = Jwts.builder()
                .setIssuer("cxb")
                .setSubject("Bob")
                .setAudience("you")
                .setExpiration(TimeUtils.addMonths(1))
                .setIssuedAt(new Date())
                .setId("1")
                .signWith(key).compact();
        return jws;
    }

    //
    public static String read(String jws) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jws);
        System.out.println(claimsJws);
        return null;
    }
}
