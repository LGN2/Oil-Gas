package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.OilFieldDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class OilFieldService {
 private final OilFieldRepository oilFieldRepository;
 public OilFieldDTO create(OilFieldDTO dto){
 OilField entity=new OilField();
 entity.setName(dto.getName());
 entity.setLocation(dto.getLocation());
 entity.setRegion(dto.getRegion());

 return convertToDTO(oilFieldRepository.save(entity)); }
 public List<OilFieldDTO> getAll(){return convertToDTO(oilFieldRepository.findByIsActiveTrue());}
 public OilFieldDTO getById(Long id){return convertToDTO(active(id));}
 public OilFieldDTO update(Long id,OilFieldDTO dto){ OilField entity=active(id);
 entity.setName(dto.getName());
 entity.setLocation(dto.getLocation());
 entity.setRegion(dto.getRegion());

 return convertToDTO(oilFieldRepository.save(entity));}
 public void delete(Long id){OilField entity=active(id);entity.setIsActive(false);oilFieldRepository.save(entity);}
 private OilField active(Long id){return oilFieldRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("OilField not found"));}
 public OilFieldDTO convertToDTO(OilField entity){return OilFieldDTO.builder().id(entity.getId()).name(entity.getName()).location(entity.getLocation()).region(entity.getRegion()).build();}
 public List<OilFieldDTO> convertToDTO(List<OilField> list){return list.stream().map(this::convertToDTO).toList();}
}
