package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class StorageTankDTO { private Long id;
 @NotBlank @Size(max=50) private String tankCode;
 @NotNull @Positive private BigDecimal capacity;
 @NotNull @PositiveOrZero private BigDecimal currentLevel;
 @NotBlank @Size(max=50) private String product;
 @NotNull private Long oilFieldId;
}
