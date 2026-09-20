package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.util.*;
@Entity @Table(name="wells") @Getter @Setter @NoArgsConstructor
public class Well extends BaseClass {
 @Column(nullable=false,length=50,unique=true) private String wellCode; @Column(nullable=false,precision=12,scale=2) private BigDecimal depth; @Column(nullable=false,length=50) private String type; @Column(nullable=false,length=30) private String status;
 @ManyToOne @JoinColumn(name="oil_field_id",nullable=false) private OilField oilField;
 @ManyToOne @JoinColumn(name="rig_id") private Rig rig;
 @OneToMany(mappedBy="well") private List<ProductionReading> productionReadings=new ArrayList<>();
}