package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.PersonnelDTO; import com.CV.Oil_Gas.services.PersonnelService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/personnel") @RequiredArgsConstructor
public class PersonnelController {
 private final PersonnelService personnelService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public PersonnelDTO create(@Valid @RequestBody PersonnelDTO dto){return personnelService.create(dto);}
 @GetMapping public List<PersonnelDTO> all(){return personnelService.getAll();}
 @GetMapping("/{id}") public PersonnelDTO one(@PathVariable Long id){return personnelService.getById(id);}
 @PutMapping("/{id}") public PersonnelDTO update(@PathVariable Long id,@Valid @RequestBody PersonnelDTO dto){return personnelService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){personnelService.delete(id);}
}