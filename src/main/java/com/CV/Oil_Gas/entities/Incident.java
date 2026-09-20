package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.time.LocalDate;
@Entity @Table(name="incidents") @Getter @Setter @NoArgsConstructor
public class Incident extends BaseClass {
 @Column(nullable=false) private LocalDate incidentDate; @Column(nullable=false,length=30) private String severity; @Column(nullable=false,length=1000) private String description; @Column(nullable=false,length=30) private String status;
 @ManyToOne @JoinColumn(name="oil_field_id",nullable=false) private OilField oilField; @ManyToOne @JoinColumn(name="reported_by_id",nullable=false) private Personnel reportedBy;
}