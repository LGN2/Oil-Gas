package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.WellDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class WellService {
 private final WellRepository wellRepository;
 private final OilFieldRepository oilFieldRepository;
 private final RigRepository rigRepository;
 public WellDTO create(WellDTO dto){
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 Rig rig=dto.getRigId()==null?null:rigRepository.findByIdAndIsActiveTrue(dto.getRigId()).orElseThrow(()->new ResourceNotFoundException("Rig not found"));
 Well entity=new Well();
 entity.setWellCode(dto.getWellCode());
 entity.setDepth(dto.getDepth());
 entity.setType(dto.getType());
 entity.setStatus(dto.getStatus());
 entity.setOilField(oilField);
 entity.setRig(rig);
 return convertToDTO(wellRepository.save(entity)); }
 public List<WellDTO> getAll(){return convertToDTO(wellRepository.findByIsActiveTrue());}
 public WellDTO getById(Long id){return convertToDTO(active(id));}
 public WellDTO update(Long id,WellDTO dto){ Well entity=active(id);
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 Rig rig=dto.getRigId()==null?null:rigRepository.findByIdAndIsActiveTrue(dto.getRigId()).orElseThrow(()->new ResourceNotFoundException("Rig not found"));
 entity.setWellCode(dto.getWellCode());
 entity.setDepth(dto.getDepth());
 entity.setType(dto.getType());
 entity.setStatus(dto.getStatus());
 entity.setOilField(oilField);
 entity.setRig(rig);
 return convertToDTO(wellRepository.save(entity));}
 public void delete(Long id){Well entity=active(id);entity.setIsActive(false);wellRepository.save(entity);}
 private Well active(Long id){return wellRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Well not found"));}
 public WellDTO convertToDTO(Well entity){return WellDTO.builder().id(entity.getId()).wellCode(entity.getWellCode()).depth(entity.getDepth()).type(entity.getType()).status(entity.getStatus()).oilFieldId(entity.getOilField()==null?null:entity.getOilField().getId()).rigId(entity.getRig()==null?null:entity.getRig().getId()).build();}
 public List<WellDTO> convertToDTO(List<Well> list){return list.stream().map(this::convertToDTO).toList();}
}
