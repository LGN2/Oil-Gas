package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.StorageTankDTO; import com.CV.Oil_Gas.services.StorageTankService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/storage-tanks") @RequiredArgsConstructor
public class StorageTankController {
 private final StorageTankService storageTankService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public StorageTankDTO create(@Valid @RequestBody StorageTankDTO dto){return storageTankService.create(dto);}
 @GetMapping public List<StorageTankDTO> all(){return storageTankService.getAll();}
 @GetMapping("/{id}") public StorageTankDTO one(@PathVariable Long id){return storageTankService.getById(id);}
 @PutMapping("/{id}") public StorageTankDTO update(@PathVariable Long id,@Valid @RequestBody StorageTankDTO dto){return storageTankService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){storageTankService.delete(id);}
}