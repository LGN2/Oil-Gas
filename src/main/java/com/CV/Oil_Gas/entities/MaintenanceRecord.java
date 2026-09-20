package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="maintenance_records") @Getter @Setter @NoArgsConstructor
public class MaintenanceRecord extends BaseClass {
 @Column(nullable=false) private LocalDate maintenanceDate; @Column(nullable=false,length=500) private String description; @Column(nullable=false,precision=12,scale=2) private BigDecimal cost;
 @ManyToOne @JoinColumn(name="equipment_id",nullable=false) private Equipment equipment; @ManyToOne @JoinColumn(name="technician_id",nullable=false) private Technician technician;
}