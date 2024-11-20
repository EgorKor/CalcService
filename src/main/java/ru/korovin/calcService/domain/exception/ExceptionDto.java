package ru.korovin.calcService.domain.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ExceptionDto {
    private String message;
    private Timestamp timestamp;

    @JsonCreator
    public ExceptionDto(@JsonProperty("message") String message, @JsonProperty("timestamp") Timestamp timestamp){
        this.message = message;
        this.timestamp = timestamp;
    }
}
