package com.CV.Oil_Gas.entities;
import jakarta.persistence.*; import lombok.*; import java.time.LocalDate;
@Entity @Table(name="inspections") @Getter @Setter @NoArgsConstructor
public class Inspection extends BaseClass {
 @Column(nullable=false) private LocalDate inspectionDate; @Column(nullable=false,length=100) private String result; @Column(length=500) private String notes;
 @ManyToOne @JoinColumn(name="well_id") private Well well; @ManyToOne @JoinColumn(name="pipeline_id") private Pipeline pipeline; @ManyToOne @JoinColumn(name="inspector_id",nullable=false) private Inspector inspector;
}