package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.TechnicianDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class TechnicianService {
 private final TechnicianRepository technicianRepository;
 public TechnicianDTO create(TechnicianDTO dto){
 Technician entity=new Technician();
 entity.setName(dto.getName());
 entity.setSpecialization(dto.getSpecialization());
 entity.setPhoneNumber(dto.getPhoneNumber());

 return convertToDTO(technicianRepository.save(entity)); }
 public List<TechnicianDTO> getAll(){return convertToDTO(technicianRepository.findByIsActiveTrue());}
 public TechnicianDTO getById(Long id){return convertToDTO(active(id));}
 public TechnicianDTO update(Long id,TechnicianDTO dto){ Technician entity=active(id);
 entity.setName(dto.getName());
 entity.setSpecialization(dto.getSpecialization());
 entity.setPhoneNumber(dto.getPhoneNumber());

 return convertToDTO(technicianRepository.save(entity));}
 public void delete(Long id){Technician entity=active(id);entity.setIsActive(false);technicianRepository.save(entity);}
 private Technician active(Long id){return technicianRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Technician not found"));}
 public TechnicianDTO convertToDTO(Technician entity){return TechnicianDTO.builder().id(entity.getId()).name(entity.getName()).specialization(entity.getSpecialization()).phoneNumber(entity.getPhoneNumber()).build();}
 public List<TechnicianDTO> convertToDTO(List<Technician> list){return list.stream().map(this::convertToDTO).toList();}
}
