package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class WellDTO { private Long id;
 @NotBlank @Size(max=50) private String wellCode;
 @NotNull @Positive private BigDecimal depth;
 @NotBlank @Size(max=50) private String type;
 @NotBlank @Size(max=30) private String status;
 @NotNull private Long oilFieldId;
  private Long rigId;
}
