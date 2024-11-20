package ru.korovin.calcService.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyAccessTokenRequestDto {
    private String token;

    @JsonCreator
    public VerifyAccessTokenRequestDto(@JsonProperty("token") String token) {
        this.token = token;
    }
}
