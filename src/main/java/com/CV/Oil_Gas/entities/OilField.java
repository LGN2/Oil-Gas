package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.util.*;
@Entity @Table(name="oil_fields") @Getter @Setter @NoArgsConstructor
public class OilField extends BaseClass {
 @Column(nullable=false,length=100) private String name; @Column(nullable=false,length=150) private String location; @Column(nullable=false,length=100) private String region;
 @OneToMany(mappedBy="oilField") private List<Well> wells=new ArrayList<>();
 @OneToMany(mappedBy="oilField") private List<Pipeline> pipelines=new ArrayList<>();
 @OneToMany(mappedBy="oilField") private List<StorageTank> storageTanks=new ArrayList<>();
 @OneToMany(mappedBy="oilField") private List<Equipment> equipment=new ArrayList<>();
 @OneToMany(mappedBy="oilField") private List<Personnel> personnel=new ArrayList<>();
 @OneToMany(mappedBy="oilField") private List<Incident> incidents=new ArrayList<>();
}