package com.ming.common.utils;

import com.ming.bean.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.ClientInfoStatus;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.expired_date}")
    public Long exportDate;

    @Value("${jwt.secret}")
    public String secret;
    //1. 获取json
    public String createToken(Map map){
        return Jwts.builder()
                .setClaims(map)
                .setExpiration(exportDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    //2. 获取登录信息
    public String getUserMessage(String token){
        Claims claims=getClains(token);
        return (String) claims.get("userName");

    }

    //3. 从token中获取信息
    public Claims getClains(String token){
        Claims claims=  Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    //判断token是否还有效 判断两点1.用户名是否正确，二.判断token是否过期
    public boolean validateToken(String token, User user){
        String userMessage=getUserMessage(token);
        return userMessage.equals(user.getUserName()) && !isTokenExpired(token);
    }
    /**
     * 判断token是否已经失效
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    public Date getExpiredDateFromToken(String token){

        Claims claims=getClains(token);
        return claims.getExpiration();

    }

    //获取失效时间
    public Date exportDate(){
        Date date=new Date();
        date.setTime(date.getTime()+this.exportDate);
        return date;
    }
}
