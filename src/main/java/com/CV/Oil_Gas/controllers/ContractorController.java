package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.ContractorDTO; import com.CV.Oil_Gas.services.ContractorService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/contractors") @RequiredArgsConstructor
public class ContractorController {
 private final ContractorService contractorService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public ContractorDTO create(@Valid @RequestBody ContractorDTO dto){return contractorService.create(dto);}
 @GetMapping public List<ContractorDTO> all(){return contractorService.getAll();}
 @GetMapping("/{id}") public ContractorDTO one(@PathVariable Long id){return contractorService.getById(id);}
 @PutMapping("/{id}") public ContractorDTO update(@PathVariable Long id,@Valid @RequestBody ContractorDTO dto){return contractorService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){contractorService.delete(id);}
}