package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.ContractorDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class ContractorService {
 private final ContractorRepository contractorRepository;
 public ContractorDTO create(ContractorDTO dto){
 Contractor entity=new Contractor();
 entity.setName(dto.getName());
 entity.setEmail(dto.getEmail());
 entity.setPhoneNumber(dto.getPhoneNumber());
 entity.setCountry(dto.getCountry());

 return convertToDTO(contractorRepository.save(entity)); }
 public List<ContractorDTO> getAll(){return convertToDTO(contractorRepository.findByIsActiveTrue());}
 public ContractorDTO getById(Long id){return convertToDTO(active(id));}
 public ContractorDTO update(Long id,ContractorDTO dto){ Contractor entity=active(id);
 entity.setName(dto.getName());
 entity.setEmail(dto.getEmail());
 entity.setPhoneNumber(dto.getPhoneNumber());
 entity.setCountry(dto.getCountry());

 return convertToDTO(contractorRepository.save(entity));}
 public void delete(Long id){Contractor entity=active(id);entity.setIsActive(false);contractorRepository.save(entity);}
 private Contractor active(Long id){return contractorRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Contractor not found"));}
 public ContractorDTO convertToDTO(Contractor entity){return ContractorDTO.builder().id(entity.getId()).name(entity.getName()).email(entity.getEmail()).phoneNumber(entity.getPhoneNumber()).country(entity.getCountry()).build();}
 public List<ContractorDTO> convertToDTO(List<Contractor> list){return list.stream().map(this::convertToDTO).toList();}
}
