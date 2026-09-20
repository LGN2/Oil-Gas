package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.WellDTO; import com.CV.Oil_Gas.services.WellService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/wells") @RequiredArgsConstructor
public class WellController {
 private final WellService wellService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public WellDTO create(@Valid @RequestBody WellDTO dto){return wellService.create(dto);}
 @GetMapping public List<WellDTO> all(){return wellService.getAll();}
 @GetMapping("/{id}") public WellDTO one(@PathVariable Long id){return wellService.getById(id);}
 @PutMapping("/{id}") public WellDTO update(@PathVariable Long id,@Valid @RequestBody WellDTO dto){return wellService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){wellService.delete(id);}
}