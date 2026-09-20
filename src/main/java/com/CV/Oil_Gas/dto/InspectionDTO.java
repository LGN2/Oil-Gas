package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class InspectionDTO { private Long id;
 @NotNull private LocalDate inspectionDate;
 @NotBlank @Size(max=100) private String result;
 @Size(max=500) private String notes;
  private Long wellId;
  private Long pipelineId;
 @NotNull private Long inspectorId;
}
