package ru.korovin.calcService.domain.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccessTokenVerificationException extends RuntimeException{
    private String message;
}
