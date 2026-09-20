package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.InspectionDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class InspectionService {
 private final InspectionRepository inspectionRepository;
 private final WellRepository wellRepository;
 private final PipelineRepository pipelineRepository;
 private final InspectorRepository inspectorRepository;
 public InspectionDTO create(InspectionDTO dto){
 Well well=dto.getWellId()==null?null:wellRepository.findByIdAndIsActiveTrue(dto.getWellId()).orElseThrow(()->new ResourceNotFoundException("Well not found"));
 Pipeline pipeline=dto.getPipelineId()==null?null:pipelineRepository.findByIdAndIsActiveTrue(dto.getPipelineId()).orElseThrow(()->new ResourceNotFoundException("Pipeline not found"));
 Inspector inspector=inspectorRepository.findByIdAndIsActiveTrue(dto.getInspectorId()).orElseThrow(()->new ResourceNotFoundException("Inspector not found"));
 Inspection entity=new Inspection();
 entity.setInspectionDate(dto.getInspectionDate());
 entity.setResult(dto.getResult());
 entity.setNotes(dto.getNotes());
 entity.setWell(well);
 entity.setPipeline(pipeline);
 entity.setInspector(inspector);
 return convertToDTO(inspectionRepository.save(entity)); }
 public List<InspectionDTO> getAll(){return convertToDTO(inspectionRepository.findByIsActiveTrue());}
 public InspectionDTO getById(Long id){return convertToDTO(active(id));}
 public InspectionDTO update(Long id,InspectionDTO dto){ Inspection entity=active(id);
 Well well=dto.getWellId()==null?null:wellRepository.findByIdAndIsActiveTrue(dto.getWellId()).orElseThrow(()->new ResourceNotFoundException("Well not found"));
 Pipeline pipeline=dto.getPipelineId()==null?null:pipelineRepository.findByIdAndIsActiveTrue(dto.getPipelineId()).orElseThrow(()->new ResourceNotFoundException("Pipeline not found"));
 Inspector inspector=inspectorRepository.findByIdAndIsActiveTrue(dto.getInspectorId()).orElseThrow(()->new ResourceNotFoundException("Inspector not found"));
 entity.setInspectionDate(dto.getInspectionDate());
 entity.setResult(dto.getResult());
 entity.setNotes(dto.getNotes());
 entity.setWell(well);
 entity.setPipeline(pipeline);
 entity.setInspector(inspector);
 return convertToDTO(inspectionRepository.save(entity));}
 public void delete(Long id){Inspection entity=active(id);entity.setIsActive(false);inspectionRepository.save(entity);}
 private Inspection active(Long id){return inspectionRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Inspection not found"));}
 public InspectionDTO convertToDTO(Inspection entity){return InspectionDTO.builder().id(entity.getId()).inspectionDate(entity.getInspectionDate()).result(entity.getResult()).notes(entity.getNotes()).wellId(entity.getWell()==null?null:entity.getWell().getId()).pipelineId(entity.getPipeline()==null?null:entity.getPipeline().getId()).inspectorId(entity.getInspector()==null?null:entity.getInspector().getId()).build();}
 public List<InspectionDTO> convertToDTO(List<Inspection> list){return list.stream().map(this::convertToDTO).toList();}
}
