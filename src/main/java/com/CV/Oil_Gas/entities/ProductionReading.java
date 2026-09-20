package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="production_readings") @Getter @Setter @NoArgsConstructor
public class ProductionReading extends BaseClass {
 @Column(nullable=false) private LocalDate readingDate; @Column(nullable=false,precision=14,scale=2) private BigDecimal oilVolume; @Column(nullable=false,precision=14,scale=2) private BigDecimal gasVolume; @Column(nullable=false,precision=14,scale=2) private BigDecimal waterVolume;
 @ManyToOne @JoinColumn(name="well_id",nullable=false) private Well well;
}