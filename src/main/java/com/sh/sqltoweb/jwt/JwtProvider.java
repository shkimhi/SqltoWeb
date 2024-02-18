package com.sh.sqltoweb.jwt;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JwtProvider {
    @Value("${jwt.secret}")
    private String Secret;

    @Value("${jwt.headerstring}")
    private String HeaderString;

    @Value("${jwt.expirationtime}")
    private String ExpirationTime;

    @Value("${jwt.tokenprefix}")
    private String TokenPrefix;



}
