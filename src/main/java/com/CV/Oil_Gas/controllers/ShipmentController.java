package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.ShipmentDTO; import com.CV.Oil_Gas.services.ShipmentService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/shipments") @RequiredArgsConstructor
public class ShipmentController {
 private final ShipmentService shipmentService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public ShipmentDTO create(@Valid @RequestBody ShipmentDTO dto){return shipmentService.create(dto);}
 @GetMapping public List<ShipmentDTO> all(){return shipmentService.getAll();}
 @GetMapping("/{id}") public ShipmentDTO one(@PathVariable Long id){return shipmentService.getById(id);}
 @PutMapping("/{id}") public ShipmentDTO update(@PathVariable Long id,@Valid @RequestBody ShipmentDTO dto){return shipmentService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){shipmentService.delete(id);}
}