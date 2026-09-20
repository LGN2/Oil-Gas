package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.EquipmentDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class EquipmentService {
 private final EquipmentRepository equipmentRepository;
 private final OilFieldRepository oilFieldRepository;
 public EquipmentDTO create(EquipmentDTO dto){
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 Equipment entity=new Equipment();
 entity.setName(dto.getName());
 entity.setSerialNumber(dto.getSerialNumber());
 entity.setType(dto.getType());
 entity.setStatus(dto.getStatus());
 entity.setOilField(oilField);
 return convertToDTO(equipmentRepository.save(entity)); }
 public List<EquipmentDTO> getAll(){return convertToDTO(equipmentRepository.findByIsActiveTrue());}
 public EquipmentDTO getById(Long id){return convertToDTO(active(id));}
 public EquipmentDTO update(Long id,EquipmentDTO dto){ Equipment entity=active(id);
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 entity.setName(dto.getName());
 entity.setSerialNumber(dto.getSerialNumber());
 entity.setType(dto.getType());
 entity.setStatus(dto.getStatus());
 entity.setOilField(oilField);
 return convertToDTO(equipmentRepository.save(entity));}
 public void delete(Long id){Equipment entity=active(id);entity.setIsActive(false);equipmentRepository.save(entity);}
 private Equipment active(Long id){return equipmentRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Equipment not found"));}
 public EquipmentDTO convertToDTO(Equipment entity){return EquipmentDTO.builder().id(entity.getId()).name(entity.getName()).serialNumber(entity.getSerialNumber()).type(entity.getType()).status(entity.getStatus()).oilFieldId(entity.getOilField()==null?null:entity.getOilField().getId()).build();}
 public List<EquipmentDTO> convertToDTO(List<Equipment> list){return list.stream().map(this::convertToDTO).toList();}
}
