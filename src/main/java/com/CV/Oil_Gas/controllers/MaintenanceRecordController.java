package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.MaintenanceRecordDTO; import com.CV.Oil_Gas.services.MaintenanceRecordService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/maintenance-records") @RequiredArgsConstructor
public class MaintenanceRecordController {
 private final MaintenanceRecordService maintenanceRecordService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public MaintenanceRecordDTO create(@Valid @RequestBody MaintenanceRecordDTO dto){return maintenanceRecordService.create(dto);}
 @GetMapping public List<MaintenanceRecordDTO> all(){return maintenanceRecordService.getAll();}
 @GetMapping("/{id}") public MaintenanceRecordDTO one(@PathVariable Long id){return maintenanceRecordService.getById(id);}
 @PutMapping("/{id}") public MaintenanceRecordDTO update(@PathVariable Long id,@Valid @RequestBody MaintenanceRecordDTO dto){return maintenanceRecordService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){maintenanceRecordService.delete(id);}
}