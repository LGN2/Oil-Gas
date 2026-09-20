package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EquipmentDTO { private Long id;
 @NotBlank @Size(max=100) private String name;
 @NotBlank @Size(max=100) private String serialNumber;
 @NotBlank @Size(max=50) private String type;
 @NotBlank @Size(max=30) private String status;
 @NotNull private Long oilFieldId;
}
