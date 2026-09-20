package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.OilFieldDTO; import com.CV.Oil_Gas.services.OilFieldService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/oil-fields") @RequiredArgsConstructor
public class OilFieldController {
 private final OilFieldService oilFieldService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public OilFieldDTO create(@Valid @RequestBody OilFieldDTO dto){return oilFieldService.create(dto);}
 @GetMapping public List<OilFieldDTO> all(){return oilFieldService.getAll();}
 @GetMapping("/{id}") public OilFieldDTO one(@PathVariable Long id){return oilFieldService.getById(id);}
 @PutMapping("/{id}") public OilFieldDTO update(@PathVariable Long id,@Valid @RequestBody OilFieldDTO dto){return oilFieldService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){oilFieldService.delete(id);}
}