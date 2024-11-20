package ru.korovin.calcService.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAccessResponseDto {
    private String token;

    @JsonCreator
    public GetAccessResponseDto(@JsonProperty("token") String token){
        this.token = token;
    }
}
