package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.util.*;
@Entity @Table(name="technicians") @Getter @Setter @NoArgsConstructor
public class Technician extends BaseClass {
 @Column(nullable=false,length=100) private String name; @Column(nullable=false,length=100) private String specialization; @Column(nullable=false,length=20) private String phoneNumber;
 @OneToMany(mappedBy="technician") private List<MaintenanceRecord> maintenanceRecords=new ArrayList<>();
}