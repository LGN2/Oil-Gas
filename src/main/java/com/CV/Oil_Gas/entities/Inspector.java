package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.util.*;
@Entity @Table(name="inspectors") @Getter @Setter @NoArgsConstructor
public class Inspector extends BaseClass {
 @Column(nullable=false,length=100) private String name; @Column(nullable=false,length=100,unique=true) private String licenseNumber; @Column(nullable=false,length=20) private String phoneNumber;
 @OneToMany(mappedBy="inspector") private List<Inspection> inspections=new ArrayList<>();
}