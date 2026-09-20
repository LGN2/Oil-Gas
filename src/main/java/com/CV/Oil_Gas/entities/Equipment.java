package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.util.*;
@Entity @Table(name="equipment") @Getter @Setter @NoArgsConstructor
public class Equipment extends BaseClass {
 @Column(nullable=false,length=100) private String name; @Column(nullable=false,length=100,unique=true) private String serialNumber; @Column(nullable=false,length=50) private String type; @Column(nullable=false,length=30) private String status;
 @ManyToOne @JoinColumn(name="oil_field_id",nullable=false) private OilField oilField; @OneToMany(mappedBy="equipment") private List<MaintenanceRecord> maintenanceRecords=new ArrayList<>();
}