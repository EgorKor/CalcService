package ru.korovin.calcService.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.korovin.calcService.config.UserAuthentication;
import ru.korovin.calcService.domain.dto.GetAccessRequestDto;
import ru.korovin.calcService.domain.dto.GetAccessResponseDto;
import ru.korovin.calcService.domain.exception.AccessTokenVerificationException;
import ru.korovin.calcService.domain.exception.ExceptionDto;
import ru.korovin.calcService.service.AccessTokenVerifyService;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@RestController
@RequestMapping("/api/v1/calcService/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AccessTokenVerifyService accessTokenVerifyService;

    @PostMapping("/getAccess")
    public GetAccessResponseDto getAccess(@RequestBody GetAccessRequestDto dto, HttpServletRequest request, HttpServletResponse response) {
        SecurityContextHolder.getContext().setAuthentication(new UserAuthentication());
        HttpSession session = request.getSession(true);
        accessTokenVerifyService.verify(dto.getToken());
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return new GetAccessResponseDto(dto.getToken());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler
    public ExceptionDto handleAccessTokenVerificationException(AccessTokenVerificationException e){
        return new ExceptionDto(e.getMessage(), Timestamp.from(Instant.now()));
    }

}