package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.util.*;
@Entity @Table(name="contractors") @Getter @Setter @NoArgsConstructor
public class Contractor extends BaseClass {
 @Column(nullable=false,length=100) private String name; @Column(nullable=false,length=150,unique=true) private String email; @Column(nullable=false,length=20) private String phoneNumber; @Column(nullable=false,length=100) private String country;
 @OneToMany(mappedBy="contractor") private List<Rig> rigs=new ArrayList<>(); @OneToMany(mappedBy="contractor") private List<Personnel> personnel=new ArrayList<>();
}