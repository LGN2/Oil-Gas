package com.CV.Oil_Gas.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ShipmentDTO { private Long id;
 @NotNull private LocalDate shipmentDate;
 @NotNull @Positive private BigDecimal volume;
 @NotBlank @Size(max=150) private String destination;
 @NotBlank @Size(max=30) private String status;
 @NotNull private Long storageTankId;
 @NotNull private Long customerId;
}
