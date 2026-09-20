package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PersonnelDTO { private Long id;
 @NotBlank @Size(max=100) private String name;
 @NotBlank @Size(max=50) private String role;
 @NotBlank @Size(max=20) private String phoneNumber;
 @NotBlank @Size(max=150) private String certification;
 @NotNull private Long contractorId;
 @NotNull private Long oilFieldId;
}
