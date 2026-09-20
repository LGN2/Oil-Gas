package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.ShipmentDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class ShipmentService {
 private final ShipmentRepository shipmentRepository;
 private final StorageTankRepository storageTankRepository;
 private final CustomerRepository customerRepository;
 public ShipmentDTO create(ShipmentDTO dto){
 StorageTank storageTank=storageTankRepository.findByIdAndIsActiveTrue(dto.getStorageTankId()).orElseThrow(()->new ResourceNotFoundException("StorageTank not found"));
 Customer customer=customerRepository.findByIdAndIsActiveTrue(dto.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Customer not found"));
 Shipment entity=new Shipment();
 entity.setShipmentDate(dto.getShipmentDate());
 entity.setVolume(dto.getVolume());
 entity.setDestination(dto.getDestination());
 entity.setStatus(dto.getStatus());
 entity.setStorageTank(storageTank);
 entity.setCustomer(customer);
 return convertToDTO(shipmentRepository.save(entity)); }
 public List<ShipmentDTO> getAll(){return convertToDTO(shipmentRepository.findByIsActiveTrue());}
 public ShipmentDTO getById(Long id){return convertToDTO(active(id));}
 public ShipmentDTO update(Long id,ShipmentDTO dto){ Shipment entity=active(id);
 StorageTank storageTank=storageTankRepository.findByIdAndIsActiveTrue(dto.getStorageTankId()).orElseThrow(()->new ResourceNotFoundException("StorageTank not found"));
 Customer customer=customerRepository.findByIdAndIsActiveTrue(dto.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Customer not found"));
 entity.setShipmentDate(dto.getShipmentDate());
 entity.setVolume(dto.getVolume());
 entity.setDestination(dto.getDestination());
 entity.setStatus(dto.getStatus());
 entity.setStorageTank(storageTank);
 entity.setCustomer(customer);
 return convertToDTO(shipmentRepository.save(entity));}
 public void delete(Long id){Shipment entity=active(id);entity.setIsActive(false);shipmentRepository.save(entity);}
 private Shipment active(Long id){return shipmentRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Shipment not found"));}
 public ShipmentDTO convertToDTO(Shipment entity){return ShipmentDTO.builder().id(entity.getId()).shipmentDate(entity.getShipmentDate()).volume(entity.getVolume()).destination(entity.getDestination()).status(entity.getStatus()).storageTankId(entity.getStorageTank()==null?null:entity.getStorageTank().getId()).customerId(entity.getCustomer()==null?null:entity.getCustomer().getId()).build();}
 public List<ShipmentDTO> convertToDTO(List<Shipment> list){return list.stream().map(this::convertToDTO).toList();}
}
