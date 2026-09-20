package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PipelineDTO { private Long id;
 @NotBlank @Size(max=50) private String pipelineCode;
 @NotNull @Positive private BigDecimal lengthKm;
 @NotNull @Positive private BigDecimal diameter;
 @NotBlank @Size(max=30) private String status;
 @NotNull private Long oilFieldId;
}
