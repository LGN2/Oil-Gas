package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.ProductionReadingDTO; import com.CV.Oil_Gas.services.ProductionReadingService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/production-readings") @RequiredArgsConstructor
public class ProductionReadingController {
 private final ProductionReadingService productionReadingService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public ProductionReadingDTO create(@Valid @RequestBody ProductionReadingDTO dto){return productionReadingService.create(dto);}
 @GetMapping public List<ProductionReadingDTO> all(){return productionReadingService.getAll();}
 @GetMapping("/{id}") public ProductionReadingDTO one(@PathVariable Long id){return productionReadingService.getById(id);}
 @PutMapping("/{id}") public ProductionReadingDTO update(@PathVariable Long id,@Valid @RequestBody ProductionReadingDTO dto){return productionReadingService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){productionReadingService.delete(id);}
}