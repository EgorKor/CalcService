package ru.korovin.calcService.service;

import ru.korovin.calcService.domain.exception.AccessTokenVerificationException;

public interface AccessTokenVerifyService {
    void verify(String token) throws AccessTokenVerificationException;
}
