package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="personnel") @Getter @Setter @NoArgsConstructor
public class Personnel extends BaseClass {
 @Column(nullable=false,length=100) private String name; @Column(nullable=false,length=50) private String role; @Column(nullable=false,length=20) private String phoneNumber; @Column(nullable=false,length=150) private String certification;
 @ManyToOne @JoinColumn(name="contractor_id",nullable=false) private Contractor contractor; @ManyToOne @JoinColumn(name="oil_field_id",nullable=false) private OilField oilField;
}