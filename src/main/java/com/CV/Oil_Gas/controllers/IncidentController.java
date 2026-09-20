package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.IncidentDTO; import com.CV.Oil_Gas.services.IncidentService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/incidents") @RequiredArgsConstructor
public class IncidentController {
 private final IncidentService incidentService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public IncidentDTO create(@Valid @RequestBody IncidentDTO dto){return incidentService.create(dto);}
 @GetMapping public List<IncidentDTO> all(){return incidentService.getAll();}
 @GetMapping("/{id}") public IncidentDTO one(@PathVariable Long id){return incidentService.getById(id);}
 @PutMapping("/{id}") public IncidentDTO update(@PathVariable Long id,@Valid @RequestBody IncidentDTO dto){return incidentService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){incidentService.delete(id);}
}