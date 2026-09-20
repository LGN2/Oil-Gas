package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.PersonnelDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class PersonnelService {
 private final PersonnelRepository personnelRepository;
 private final ContractorRepository contractorRepository;
 private final OilFieldRepository oilFieldRepository;
 public PersonnelDTO create(PersonnelDTO dto){
 Contractor contractor=contractorRepository.findByIdAndIsActiveTrue(dto.getContractorId()).orElseThrow(()->new ResourceNotFoundException("Contractor not found"));
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 Personnel entity=new Personnel();
 entity.setName(dto.getName());
 entity.setRole(dto.getRole());
 entity.setPhoneNumber(dto.getPhoneNumber());
 entity.setCertification(dto.getCertification());
 entity.setContractor(contractor);
 entity.setOilField(oilField);
 return convertToDTO(personnelRepository.save(entity)); }
 public List<PersonnelDTO> getAll(){return convertToDTO(personnelRepository.findByIsActiveTrue());}
 public PersonnelDTO getById(Long id){return convertToDTO(active(id));}
 public PersonnelDTO update(Long id,PersonnelDTO dto){ Personnel entity=active(id);
 Contractor contractor=contractorRepository.findByIdAndIsActiveTrue(dto.getContractorId()).orElseThrow(()->new ResourceNotFoundException("Contractor not found"));
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 entity.setName(dto.getName());
 entity.setRole(dto.getRole());
 entity.setPhoneNumber(dto.getPhoneNumber());
 entity.setCertification(dto.getCertification());
 entity.setContractor(contractor);
 entity.setOilField(oilField);
 return convertToDTO(personnelRepository.save(entity));}
 public void delete(Long id){Personnel entity=active(id);entity.setIsActive(false);personnelRepository.save(entity);}
 private Personnel active(Long id){return personnelRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Personnel not found"));}
 public PersonnelDTO convertToDTO(Personnel entity){return PersonnelDTO.builder().id(entity.getId()).name(entity.getName()).role(entity.getRole()).phoneNumber(entity.getPhoneNumber()).certification(entity.getCertification()).contractorId(entity.getContractor()==null?null:entity.getContractor().getId()).oilFieldId(entity.getOilField()==null?null:entity.getOilField().getId()).build();}
 public List<PersonnelDTO> convertToDTO(List<Personnel> list){return list.stream().map(this::convertToDTO).toList();}
}
