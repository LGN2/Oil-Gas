package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ProductionReadingDTO { private Long id;
 @NotNull @PastOrPresent private LocalDate readingDate;
 @NotNull @PositiveOrZero private BigDecimal oilVolume;
 @NotNull @PositiveOrZero private BigDecimal gasVolume;
 @NotNull @PositiveOrZero private BigDecimal waterVolume;
 @NotNull private Long wellId;
}
