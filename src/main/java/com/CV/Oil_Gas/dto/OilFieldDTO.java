package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class OilFieldDTO { private Long id;
 @NotBlank @Size(max=100) private String name;
 @NotBlank @Size(max=150) private String location;
 @NotBlank @Size(max=100) private String region;
}
