package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.RigDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class RigService {
 private final RigRepository rigRepository;
 private final ContractorRepository contractorRepository;
 public RigDTO create(RigDTO dto){
 Contractor contractor=contractorRepository.findByIdAndIsActiveTrue(dto.getContractorId()).orElseThrow(()->new ResourceNotFoundException("Contractor not found"));
 Rig entity=new Rig();
 entity.setName(dto.getName());
 entity.setModel(dto.getModel());
 entity.setCapacity(dto.getCapacity());
 entity.setContractor(contractor);
 return convertToDTO(rigRepository.save(entity)); }
 public List<RigDTO> getAll(){return convertToDTO(rigRepository.findByIsActiveTrue());}
 public RigDTO getById(Long id){return convertToDTO(active(id));}
 public RigDTO update(Long id,RigDTO dto){ Rig entity=active(id);
 Contractor contractor=contractorRepository.findByIdAndIsActiveTrue(dto.getContractorId()).orElseThrow(()->new ResourceNotFoundException("Contractor not found"));
 entity.setName(dto.getName());
 entity.setModel(dto.getModel());
 entity.setCapacity(dto.getCapacity());
 entity.setContractor(contractor);
 return convertToDTO(rigRepository.save(entity));}
 public void delete(Long id){Rig entity=active(id);entity.setIsActive(false);rigRepository.save(entity);}
 private Rig active(Long id){return rigRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Rig not found"));}
 public RigDTO convertToDTO(Rig entity){return RigDTO.builder().id(entity.getId()).name(entity.getName()).model(entity.getModel()).capacity(entity.getCapacity()).contractorId(entity.getContractor()==null?null:entity.getContractor().getId()).build();}
 public List<RigDTO> convertToDTO(List<Rig> list){return list.stream().map(this::convertToDTO).toList();}
}
