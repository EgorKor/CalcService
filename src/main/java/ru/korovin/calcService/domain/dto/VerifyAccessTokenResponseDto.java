package ru.korovin.calcService.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyAccessTokenResponseDto {
    private boolean hasAccess;

    @JsonCreator
    public VerifyAccessTokenResponseDto(@JsonProperty("hasAccess") boolean hasAccess) {
        this.hasAccess = hasAccess;
    }
}
