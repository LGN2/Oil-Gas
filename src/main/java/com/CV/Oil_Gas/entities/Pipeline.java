package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.util.*;
@Entity @Table(name="pipelines") @Getter @Setter @NoArgsConstructor
public class Pipeline extends BaseClass {
 @Column(nullable=false,length=50,unique=true) private String pipelineCode; @Column(nullable=false,precision=12,scale=2) private BigDecimal lengthKm; @Column(nullable=false,precision=10,scale=2) private BigDecimal diameter; @Column(nullable=false,length=30) private String status;
 @ManyToOne @JoinColumn(name="oil_field_id",nullable=false) private OilField oilField;
 @ManyToMany @JoinTable(name="pipeline_storage_tanks",joinColumns=@JoinColumn(name="pipeline_id"),inverseJoinColumns=@JoinColumn(name="storage_tank_id")) private Set<StorageTank> storageTanks=new HashSet<>();
 @OneToMany(mappedBy="pipeline") private List<Inspection> inspections=new ArrayList<>();
}