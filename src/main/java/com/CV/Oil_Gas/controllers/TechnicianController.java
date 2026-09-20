package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.TechnicianDTO; import com.CV.Oil_Gas.services.TechnicianService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/technicians") @RequiredArgsConstructor
public class TechnicianController {
 private final TechnicianService technicianService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public TechnicianDTO create(@Valid @RequestBody TechnicianDTO dto){return technicianService.create(dto);}
 @GetMapping public List<TechnicianDTO> all(){return technicianService.getAll();}
 @GetMapping("/{id}") public TechnicianDTO one(@PathVariable Long id){return technicianService.getById(id);}
 @PutMapping("/{id}") public TechnicianDTO update(@PathVariable Long id,@Valid @RequestBody TechnicianDTO dto){return technicianService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){technicianService.delete(id);}
}