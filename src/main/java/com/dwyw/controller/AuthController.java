package com.dwyw.controller;

import com.dwyw.request.Login;
import com.dwyw.response.SessionResponse;
import com.dwyw.service.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private static String KEY = "d+C+JpzEpzez2NfHGCB3e43sDKR1XrrRX0Jq3cVjTac=";

    @PostMapping("/auth/login")
    public SessionResponse login(@RequestBody Login login) {
    // 디비에 사용자가 있는지 확인하는 작업 추가해야 됨
//        authService.singin(login);

        SecretKey secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(KEY));
        String jws = Jwts.builder()
            .setSubject("jmPark") // subject에 식별가능한 데이터 넣어주면 됨
            .signWith(secretKey)
            .compact();
        return new SessionResponse(jws);
    }
}
