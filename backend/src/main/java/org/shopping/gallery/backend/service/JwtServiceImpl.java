package org.shopping.gallery.backend.service;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("jwtService")
public class JwtServiceImpl implements JwtService{

    private String secretKey = "testSecretKey20230327testSecretKey20230327testSecretKey20230327";

    @Override
    public String getToken(String key, Object value) {

        Date expTime = new Date();
        expTime.setTime(expTime.getTime() + 1000 * 60 * 5);

        secretKey = secretKey.replaceAll("[^A-Za-z0-9+/=]", "");

        // 패딩 문자 추가 (길이를 4의 배수로 만듦)
        int remainder = secretKey.length() % 4;
        if (remainder > 0) {
            secretKey += "====".substring(remainder);
        }

            // Base64 디코딩
            byte[] secretByteKey = Base64.getDecoder().decode(secretKey);
            Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());

            Map<String, Object> headermap = new HashMap<>();
            headermap.put("typ", "JWT");
            headermap.put("alg", "HS256");

            Map<String, Object> map = new HashMap<>();
            map.put(key, value);

            JwtBuilder builder = Jwts.builder().setHeader(headermap)
                    .setClaims(map)
                    .setExpiration(expTime)
                    .signWith(signKey, SignatureAlgorithm.HS256);

        return builder.compact();
    }

    @Override
    public Claims getClaims(String token) {
        if(token != null && !"".equals(token)) {
            try{
                byte[] secretByteKey = Base64.getDecoder().decode(secretKey);
                Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());
                return Jwts.parserBuilder().setSigningKey(signKey).build().parseClaimsJws(token).getBody();
            } catch (ExpiredJwtException e) {
                // 만료됨
            } catch (JwtException e) {
                // 유효하지 않음
            }
        }

        return null;
    }

    @Override
    public boolean isValid(String token) {
        return this.getClaims(token) != null;
    }

    @Override
    public int getId(String token) {
        Claims claims = this.getClaims(token);

        if(claims != null) {
            return Integer.parseInt(claims.get("id").toString());
        }

        return 0;
    }
}
