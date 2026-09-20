package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class IncidentDTO { private Long id;
 @NotNull @PastOrPresent private LocalDate incidentDate;
 @NotBlank @Size(max=30) private String severity;
 @NotBlank @Size(max=1000) private String description;
 @NotBlank @Size(max=30) private String status;
 @NotNull private Long oilFieldId;
 @NotNull private Long reportedById;
}
