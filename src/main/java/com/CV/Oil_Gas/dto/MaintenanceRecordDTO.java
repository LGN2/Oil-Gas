package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MaintenanceRecordDTO { private Long id;
 @NotNull @PastOrPresent private LocalDate maintenanceDate;
 @NotBlank @Size(max=500) private String description;
 @NotNull @PositiveOrZero private BigDecimal cost;
 @NotNull private Long equipmentId;
 @NotNull private Long technicianId;
}
