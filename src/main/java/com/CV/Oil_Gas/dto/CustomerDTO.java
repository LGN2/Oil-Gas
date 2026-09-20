package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class CustomerDTO { private Long id;
 @NotBlank @Size(max=100) private String name;
 @NotBlank @Email @Size(max=150) private String email;
 @NotBlank @Size(max=20) private String phoneNumber;
 @NotBlank @Size(max=100) private String country;
}
