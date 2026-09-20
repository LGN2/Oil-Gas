package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.InspectorDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class InspectorService {
 private final InspectorRepository inspectorRepository;
 public InspectorDTO create(InspectorDTO dto){
 Inspector entity=new Inspector();
 entity.setName(dto.getName());
 entity.setLicenseNumber(dto.getLicenseNumber());
 entity.setPhoneNumber(dto.getPhoneNumber());

 return convertToDTO(inspectorRepository.save(entity)); }
 public List<InspectorDTO> getAll(){return convertToDTO(inspectorRepository.findByIsActiveTrue());}
 public InspectorDTO getById(Long id){return convertToDTO(active(id));}
 public InspectorDTO update(Long id,InspectorDTO dto){ Inspector entity=active(id);
 entity.setName(dto.getName());
 entity.setLicenseNumber(dto.getLicenseNumber());
 entity.setPhoneNumber(dto.getPhoneNumber());

 return convertToDTO(inspectorRepository.save(entity));}
 public void delete(Long id){Inspector entity=active(id);entity.setIsActive(false);inspectorRepository.save(entity);}
 private Inspector active(Long id){return inspectorRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Inspector not found"));}
 public InspectorDTO convertToDTO(Inspector entity){return InspectorDTO.builder().id(entity.getId()).name(entity.getName()).licenseNumber(entity.getLicenseNumber()).phoneNumber(entity.getPhoneNumber()).build();}
 public List<InspectorDTO> convertToDTO(List<Inspector> list){return list.stream().map(this::convertToDTO).toList();}
}
