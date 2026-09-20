package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.util.*;
@Entity @Table(name="customers") @Getter @Setter @NoArgsConstructor
public class Customer extends BaseClass {
 @Column(nullable=false,length=100) private String name; @Column(nullable=false,length=150,unique=true) private String email; @Column(nullable=false,length=20) private String phoneNumber; @Column(nullable=false,length=100) private String country;
 @OneToMany(mappedBy="customer") private List<Shipment> shipments=new ArrayList<>();
}