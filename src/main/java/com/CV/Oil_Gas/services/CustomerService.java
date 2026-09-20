package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.CustomerDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class CustomerService {
 private final CustomerRepository customerRepository;
 public CustomerDTO create(CustomerDTO dto){
 Customer entity=new Customer();
 entity.setName(dto.getName());
 entity.setEmail(dto.getEmail());
 entity.setPhoneNumber(dto.getPhoneNumber());
 entity.setCountry(dto.getCountry());

 return convertToDTO(customerRepository.save(entity)); }
 public List<CustomerDTO> getAll(){return convertToDTO(customerRepository.findByIsActiveTrue());}
 public CustomerDTO getById(Long id){return convertToDTO(active(id));}
 public CustomerDTO update(Long id,CustomerDTO dto){ Customer entity=active(id);
 entity.setName(dto.getName());
 entity.setEmail(dto.getEmail());
 entity.setPhoneNumber(dto.getPhoneNumber());
 entity.setCountry(dto.getCountry());

 return convertToDTO(customerRepository.save(entity));}
 public void delete(Long id){Customer entity=active(id);entity.setIsActive(false);customerRepository.save(entity);}
 private Customer active(Long id){return customerRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Customer not found"));}
 public CustomerDTO convertToDTO(Customer entity){return CustomerDTO.builder().id(entity.getId()).name(entity.getName()).email(entity.getEmail()).phoneNumber(entity.getPhoneNumber()).country(entity.getCountry()).build();}
 public List<CustomerDTO> convertToDTO(List<Customer> list){return list.stream().map(this::convertToDTO).toList();}
}
