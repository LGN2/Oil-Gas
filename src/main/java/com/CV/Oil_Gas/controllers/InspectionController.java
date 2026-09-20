package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.InspectionDTO; import com.CV.Oil_Gas.services.InspectionService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/inspections") @RequiredArgsConstructor
public class InspectionController {
 private final InspectionService inspectionService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public InspectionDTO create(@Valid @RequestBody InspectionDTO dto){return inspectionService.create(dto);}
 @GetMapping public List<InspectionDTO> all(){return inspectionService.getAll();}
 @GetMapping("/{id}") public InspectionDTO one(@PathVariable Long id){return inspectionService.getById(id);}
 @PutMapping("/{id}") public InspectionDTO update(@PathVariable Long id,@Valid @RequestBody InspectionDTO dto){return inspectionService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){inspectionService.delete(id);}
}