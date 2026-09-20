package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.ProductionReadingDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class ProductionReadingService {
 private final ProductionReadingRepository productionReadingRepository;
 private final WellRepository wellRepository;
 public ProductionReadingDTO create(ProductionReadingDTO dto){
 Well well=wellRepository.findByIdAndIsActiveTrue(dto.getWellId()).orElseThrow(()->new ResourceNotFoundException("Well not found"));
 ProductionReading entity=new ProductionReading();
 entity.setReadingDate(dto.getReadingDate());
 entity.setOilVolume(dto.getOilVolume());
 entity.setGasVolume(dto.getGasVolume());
 entity.setWaterVolume(dto.getWaterVolume());
 entity.setWell(well);
 return convertToDTO(productionReadingRepository.save(entity)); }
 public List<ProductionReadingDTO> getAll(){return convertToDTO(productionReadingRepository.findByIsActiveTrue());}
 public ProductionReadingDTO getById(Long id){return convertToDTO(active(id));}
 public ProductionReadingDTO update(Long id,ProductionReadingDTO dto){ ProductionReading entity=active(id);
 Well well=wellRepository.findByIdAndIsActiveTrue(dto.getWellId()).orElseThrow(()->new ResourceNotFoundException("Well not found"));
 entity.setReadingDate(dto.getReadingDate());
 entity.setOilVolume(dto.getOilVolume());
 entity.setGasVolume(dto.getGasVolume());
 entity.setWaterVolume(dto.getWaterVolume());
 entity.setWell(well);
 return convertToDTO(productionReadingRepository.save(entity));}
 public void delete(Long id){ProductionReading entity=active(id);entity.setIsActive(false);productionReadingRepository.save(entity);}
 private ProductionReading active(Long id){return productionReadingRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("ProductionReading not found"));}
 public ProductionReadingDTO convertToDTO(ProductionReading entity){return ProductionReadingDTO.builder().id(entity.getId()).readingDate(entity.getReadingDate()).oilVolume(entity.getOilVolume()).gasVolume(entity.getGasVolume()).waterVolume(entity.getWaterVolume()).wellId(entity.getWell()==null?null:entity.getWell().getId()).build();}
 public List<ProductionReadingDTO> convertToDTO(List<ProductionReading> list){return list.stream().map(this::convertToDTO).toList();}
}
