package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="shipments") @Getter @Setter @NoArgsConstructor
public class Shipment extends BaseClass {
 @Column(nullable=false) private LocalDate shipmentDate; @Column(nullable=false,precision=14,scale=2) private BigDecimal volume; @Column(nullable=false,length=150) private String destination; @Column(nullable=false,length=30) private String status;
 @ManyToOne @JoinColumn(name="storage_tank_id",nullable=false) private StorageTank storageTank; @ManyToOne @JoinColumn(name="customer_id",nullable=false) private Customer customer;
}