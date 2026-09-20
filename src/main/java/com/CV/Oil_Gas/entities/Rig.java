package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.util.*;
@Entity @Table(name="rigs") @Getter @Setter @NoArgsConstructor
public class Rig extends BaseClass {
 @Column(nullable=false,length=100) private String name; @Column(nullable=false,length=100) private String model; @Column(nullable=false,precision=12,scale=2) private BigDecimal capacity;
 @ManyToOne @JoinColumn(name="contractor_id",nullable=false) private Contractor contractor;
 @OneToMany(mappedBy="rig") private List<Well> wells=new ArrayList<>();
}