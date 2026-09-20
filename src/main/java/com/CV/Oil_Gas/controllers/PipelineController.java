package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.PipelineDTO; import com.CV.Oil_Gas.services.PipelineService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/pipelines") @RequiredArgsConstructor
public class PipelineController {
 private final PipelineService pipelineService;
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public PipelineDTO create(@Valid @RequestBody PipelineDTO dto){return pipelineService.create(dto);}
 @GetMapping public List<PipelineDTO> all(){return pipelineService.getAll();}
 @GetMapping("/{id}") public PipelineDTO one(@PathVariable Long id){return pipelineService.getById(id);}
 @PutMapping("/{id}") public PipelineDTO update(@PathVariable Long id,@Valid @RequestBody PipelineDTO dto){return pipelineService.update(id,dto);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){pipelineService.delete(id);}
}