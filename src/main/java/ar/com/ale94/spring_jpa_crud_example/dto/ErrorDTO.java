package ar.com.ale94.spring_jpa_crud_example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ErrorDTO {

    private LocalDateTime time;
    private String message;
    private String url;

    public ErrorDTO(String message, String url) {
        this.time = LocalDateTime.now();
        this.message = message;
        this.url = url.replace("uri=", "");
    }
}
