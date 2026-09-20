package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.MaintenanceRecordDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class MaintenanceRecordService {
 private final MaintenanceRecordRepository maintenanceRecordRepository;
 private final EquipmentRepository equipmentRepository;
 private final TechnicianRepository technicianRepository;
 public MaintenanceRecordDTO create(MaintenanceRecordDTO dto){
 Equipment equipment=equipmentRepository.findByIdAndIsActiveTrue(dto.getEquipmentId()).orElseThrow(()->new ResourceNotFoundException("Equipment not found"));
 Technician technician=technicianRepository.findByIdAndIsActiveTrue(dto.getTechnicianId()).orElseThrow(()->new ResourceNotFoundException("Technician not found"));
 MaintenanceRecord entity=new MaintenanceRecord();
 entity.setMaintenanceDate(dto.getMaintenanceDate());
 entity.setDescription(dto.getDescription());
 entity.setCost(dto.getCost());
 entity.setEquipment(equipment);
 entity.setTechnician(technician);
 return convertToDTO(maintenanceRecordRepository.save(entity)); }
 public List<MaintenanceRecordDTO> getAll(){return convertToDTO(maintenanceRecordRepository.findByIsActiveTrue());}
 public MaintenanceRecordDTO getById(Long id){return convertToDTO(active(id));}
 public MaintenanceRecordDTO update(Long id,MaintenanceRecordDTO dto){ MaintenanceRecord entity=active(id);
 Equipment equipment=equipmentRepository.findByIdAndIsActiveTrue(dto.getEquipmentId()).orElseThrow(()->new ResourceNotFoundException("Equipment not found"));
 Technician technician=technicianRepository.findByIdAndIsActiveTrue(dto.getTechnicianId()).orElseThrow(()->new ResourceNotFoundException("Technician not found"));
 entity.setMaintenanceDate(dto.getMaintenanceDate());
 entity.setDescription(dto.getDescription());
 entity.setCost(dto.getCost());
 entity.setEquipment(equipment);
 entity.setTechnician(technician);
 return convertToDTO(maintenanceRecordRepository.save(entity));}
 public void delete(Long id){MaintenanceRecord entity=active(id);entity.setIsActive(false);maintenanceRecordRepository.save(entity);}
 private MaintenanceRecord active(Long id){return maintenanceRecordRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("MaintenanceRecord not found"));}
 public MaintenanceRecordDTO convertToDTO(MaintenanceRecord entity){return MaintenanceRecordDTO.builder().id(entity.getId()).maintenanceDate(entity.getMaintenanceDate()).description(entity.getDescription()).cost(entity.getCost()).equipmentId(entity.getEquipment()==null?null:entity.getEquipment().getId()).technicianId(entity.getTechnician()==null?null:entity.getTechnician().getId()).build();}
 public List<MaintenanceRecordDTO> convertToDTO(List<MaintenanceRecord> list){return list.stream().map(this::convertToDTO).toList();}
}
