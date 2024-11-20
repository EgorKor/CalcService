package ru.korovin.calcService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;
import ru.korovin.calcService.domain.dto.VerifyAccessTokenRequestDto;
import ru.korovin.calcService.domain.dto.VerifyAccessTokenResponseDto;
import ru.korovin.calcService.domain.exception.AccessTokenVerificationException;
import ru.korovin.calcService.service.AccessTokenVerifyService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RemoteAccessTokenVerifyService implements AccessTokenVerifyService {
    private final RestTemplate restTemplate;
    private final Environment environment;
    @Override
    public void verify(String token) throws AccessTokenVerificationException {
        VerifyAccessTokenResponseDto response =
                restTemplate.postForEntity(Objects.requireNonNull(environment.getProperty("auth.server.url")),
                        new VerifyAccessTokenRequestDto(token),
                        VerifyAccessTokenResponseDto.class).getBody();
        if(!response.isHasAccess()){
            throw new AccessTokenVerificationException("");
        }
    }
}
