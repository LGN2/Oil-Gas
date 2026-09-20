package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.util.*;
@Entity @Table(name="storage_tanks") @Getter @Setter @NoArgsConstructor
public class StorageTank extends BaseClass {
 @Column(nullable=false,length=50,unique=true) private String tankCode; @Column(nullable=false,precision=14,scale=2) private BigDecimal capacity; @Column(nullable=false,precision=14,scale=2) private BigDecimal currentLevel; @Column(nullable=false,length=50) private String product;
 @ManyToOne @JoinColumn(name="oil_field_id",nullable=false) private OilField oilField;
 @ManyToMany(mappedBy="storageTanks") private Set<Pipeline> pipelines=new HashSet<>();
 @OneToMany(mappedBy="storageTank") private List<Shipment> shipments=new ArrayList<>();
}