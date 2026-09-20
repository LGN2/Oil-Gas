package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class RigDTO { private Long id;
 @NotBlank @Size(max=100) private String name;
 @NotBlank @Size(max=100) private String model;
 @NotNull @Positive private BigDecimal capacity;
 @NotNull private Long contractorId;
}
