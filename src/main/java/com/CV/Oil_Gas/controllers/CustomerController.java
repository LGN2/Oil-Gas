package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.CustomerDTO; import com.CV.Oil_Gas.services.CustomerService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/customers") @RequiredArgsConstructor
public class CustomerController {
 private final CustomerService customerService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public CustomerDTO create(@Valid @RequestBody CustomerDTO dto){return customerService.create(dto);}
 @GetMapping public List<CustomerDTO> all(){return customerService.getAll();}
 @GetMapping("/{id}") public CustomerDTO one(@PathVariable Long id){return customerService.getById(id);}
 @PutMapping("/{id}") public CustomerDTO update(@PathVariable Long id,@Valid @RequestBody CustomerDTO dto){return customerService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){customerService.delete(id);}
}