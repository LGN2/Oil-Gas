package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.IncidentDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class IncidentService {
 private final IncidentRepository incidentRepository;
 private final OilFieldRepository oilFieldRepository;
 private final PersonnelRepository personnelRepository;
 public IncidentDTO create(IncidentDTO dto){
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 Personnel reportedBy=personnelRepository.findByIdAndIsActiveTrue(dto.getReportedById()).orElseThrow(()->new ResourceNotFoundException("Personnel not found"));
 Incident entity=new Incident();
 entity.setIncidentDate(dto.getIncidentDate());
 entity.setSeverity(dto.getSeverity());
 entity.setDescription(dto.getDescription());
 entity.setStatus(dto.getStatus());
 entity.setOilField(oilField);
 entity.setReportedBy(reportedBy);
 return convertToDTO(incidentRepository.save(entity)); }
 public List<IncidentDTO> getAll(){return convertToDTO(incidentRepository.findByIsActiveTrue());}
 public IncidentDTO getById(Long id){return convertToDTO(active(id));}
 public IncidentDTO update(Long id,IncidentDTO dto){ Incident entity=active(id);
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 Personnel reportedBy=personnelRepository.findByIdAndIsActiveTrue(dto.getReportedById()).orElseThrow(()->new ResourceNotFoundException("Personnel not found"));
 entity.setIncidentDate(dto.getIncidentDate());
 entity.setSeverity(dto.getSeverity());
 entity.setDescription(dto.getDescription());
 entity.setStatus(dto.getStatus());
 entity.setOilField(oilField);
 entity.setReportedBy(reportedBy);
 return convertToDTO(incidentRepository.save(entity));}
 public void delete(Long id){Incident entity=active(id);entity.setIsActive(false);incidentRepository.save(entity);}
 private Incident active(Long id){return incidentRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Incident not found"));}
 public IncidentDTO convertToDTO(Incident entity){return IncidentDTO.builder().id(entity.getId()).incidentDate(entity.getIncidentDate()).severity(entity.getSeverity()).description(entity.getDescription()).status(entity.getStatus()).oilFieldId(entity.getOilField()==null?null:entity.getOilField().getId()).reportedById(entity.getReportedBy()==null?null:entity.getReportedBy().getId()).build();}
 public List<IncidentDTO> convertToDTO(List<Incident> list){return list.stream().map(this::convertToDTO).toList();}
}
