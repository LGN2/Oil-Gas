package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.StorageTankDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class StorageTankService {
 private final StorageTankRepository storageTankRepository;
 private final OilFieldRepository oilFieldRepository;
 public StorageTankDTO create(StorageTankDTO dto){
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 StorageTank entity=new StorageTank();
 entity.setTankCode(dto.getTankCode());
 entity.setCapacity(dto.getCapacity());
 entity.setCurrentLevel(dto.getCurrentLevel());
 entity.setProduct(dto.getProduct());
 entity.setOilField(oilField);
 return convertToDTO(storageTankRepository.save(entity)); }
 public List<StorageTankDTO> getAll(){return convertToDTO(storageTankRepository.findByIsActiveTrue());}
 public StorageTankDTO getById(Long id){return convertToDTO(active(id));}
 public StorageTankDTO update(Long id,StorageTankDTO dto){ StorageTank entity=active(id);
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 entity.setTankCode(dto.getTankCode());
 entity.setCapacity(dto.getCapacity());
 entity.setCurrentLevel(dto.getCurrentLevel());
 entity.setProduct(dto.getProduct());
 entity.setOilField(oilField);
 return convertToDTO(storageTankRepository.save(entity));}
 public void delete(Long id){StorageTank entity=active(id);entity.setIsActive(false);storageTankRepository.save(entity);}
 private StorageTank active(Long id){return storageTankRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("StorageTank not found"));}
 public StorageTankDTO convertToDTO(StorageTank entity){return StorageTankDTO.builder().id(entity.getId()).tankCode(entity.getTankCode()).capacity(entity.getCapacity()).currentLevel(entity.getCurrentLevel()).product(entity.getProduct()).oilFieldId(entity.getOilField()==null?null:entity.getOilField().getId()).build();}
 public List<StorageTankDTO> convertToDTO(List<StorageTank> list){return list.stream().map(this::convertToDTO).toList();}
}
