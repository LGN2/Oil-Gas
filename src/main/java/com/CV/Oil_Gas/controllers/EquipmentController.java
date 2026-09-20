package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.EquipmentDTO; import com.CV.Oil_Gas.services.EquipmentService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/equipment") @RequiredArgsConstructor
public class EquipmentController {
 private final EquipmentService equipmentService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public EquipmentDTO create(@Valid @RequestBody EquipmentDTO dto){return equipmentService.create(dto);}
 @GetMapping public List<EquipmentDTO> all(){return equipmentService.getAll();}
 @GetMapping("/{id}") public EquipmentDTO one(@PathVariable Long id){return equipmentService.getById(id);}
 @PutMapping("/{id}") public EquipmentDTO update(@PathVariable Long id,@Valid @RequestBody EquipmentDTO dto){return equipmentService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){equipmentService.delete(id);}
}