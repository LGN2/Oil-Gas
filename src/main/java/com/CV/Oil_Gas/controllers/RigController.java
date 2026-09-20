package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.RigDTO; import com.CV.Oil_Gas.services.RigService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/rigs") @RequiredArgsConstructor
public class RigController {
 private final RigService rigService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public RigDTO create(@Valid @RequestBody RigDTO dto){return rigService.create(dto);}
 @GetMapping public List<RigDTO> all(){return rigService.getAll();}
 @GetMapping("/{id}") public RigDTO one(@PathVariable Long id){return rigService.getById(id);}
 @PutMapping("/{id}") public RigDTO update(@PathVariable Long id,@Valid @RequestBody RigDTO dto){return rigService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){rigService.delete(id);}
}