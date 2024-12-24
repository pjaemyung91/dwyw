package com.dwyw.config;

import com.dwyw.config.data.UserSession;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import java.util.Base64;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
@RequiredArgsConstructor
public class AuthResolver implements HandlerMethodArgumentResolver {

    private static String KEY = "d+C+JpzEpzez2NfHGCB3e43sDKR1XrrRX0Jq3cVjTac=";
    private final AppConfig appConfig;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("parameter = {}", parameter);
        return parameter.getParameterType().equals(UserSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        log.info("hello = {}", appConfig.getHello());

        String jws = webRequest.getHeader("Authorization");
        if (jws == null || jws.equals("")) {
            throw new RuntimeException("인증되지 않은 사용자");
        }

        byte[] decodedKey = Base64.getDecoder().decode(KEY);

        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(decodedKey)
                .build()
                .parseClaimsJws(jws);

            log.info("claims = {}", claims);

        }catch(JwtException e) {
            throw new RuntimeException("JWT 에러");
        }

        return null;
    }
}
