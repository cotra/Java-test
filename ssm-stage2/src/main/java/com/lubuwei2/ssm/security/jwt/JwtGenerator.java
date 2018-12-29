package com.lubuwei2.ssm.security.jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

/**
 * Created by Administrator on 2018/3/23.
 */
public class JwtGenerator {

    // 生成方法
    public static String create() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();
        return jws;
    }
}
