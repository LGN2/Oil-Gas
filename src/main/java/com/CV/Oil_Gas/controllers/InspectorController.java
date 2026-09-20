package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.InspectorDTO; import com.CV.Oil_Gas.services.InspectorService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/inspectors") @RequiredArgsConstructor
public class InspectorController {
 private final InspectorService inspectorService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public InspectorDTO create(@Valid @RequestBody InspectorDTO dto){return inspectorService.create(dto);}
 @GetMapping public List<InspectorDTO> all(){return inspectorService.getAll();}
 @GetMapping("/{id}") public InspectorDTO one(@PathVariable Long id){return inspectorService.getById(id);}
 @PutMapping("/{id}") public InspectorDTO update(@PathVariable Long id,@Valid @RequestBody InspectorDTO dto){return inspectorService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){inspectorService.delete(id);}
}