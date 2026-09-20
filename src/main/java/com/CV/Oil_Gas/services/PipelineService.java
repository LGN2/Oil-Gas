package com.CV.Oil_Gas.services;
import com.CV.Oil_Gas.dto.PipelineDTO;
import com.CV.Oil_Gas.entities.*;
import com.CV.Oil_Gas.repositories.*;
import com.CV.Oil_Gas.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class PipelineService {
 private final PipelineRepository pipelineRepository;
 private final OilFieldRepository oilFieldRepository;
 public PipelineDTO create(PipelineDTO dto){
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 Pipeline entity=new Pipeline();
 entity.setPipelineCode(dto.getPipelineCode());
 entity.setLengthKm(dto.getLengthKm());
 entity.setDiameter(dto.getDiameter());
 entity.setStatus(dto.getStatus());
 entity.setOilField(oilField);
 return convertToDTO(pipelineRepository.save(entity)); }
 public List<PipelineDTO> getAll(){return convertToDTO(pipelineRepository.findByIsActiveTrue());}
 public PipelineDTO getById(Long id){return convertToDTO(active(id));}
 public PipelineDTO update(Long id,PipelineDTO dto){ Pipeline entity=active(id);
 OilField oilField=oilFieldRepository.findByIdAndIsActiveTrue(dto.getOilFieldId()).orElseThrow(()->new ResourceNotFoundException("OilField not found"));
 entity.setPipelineCode(dto.getPipelineCode());
 entity.setLengthKm(dto.getLengthKm());
 entity.setDiameter(dto.getDiameter());
 entity.setStatus(dto.getStatus());
 entity.setOilField(oilField);
 return convertToDTO(pipelineRepository.save(entity));}
 public void delete(Long id){Pipeline entity=active(id);entity.setIsActive(false);pipelineRepository.save(entity);}
 private Pipeline active(Long id){return pipelineRepository.findByIdAndIsActiveTrue(id).orElseThrow(()->new ResourceNotFoundException("Pipeline not found"));}
 public PipelineDTO convertToDTO(Pipeline entity){return PipelineDTO.builder().id(entity.getId()).pipelineCode(entity.getPipelineCode()).lengthKm(entity.getLengthKm()).diameter(entity.getDiameter()).status(entity.getStatus()).oilFieldId(entity.getOilField()==null?null:entity.getOilField().getId()).build();}
 public List<PipelineDTO> convertToDTO(List<Pipeline> list){return list.stream().map(this::convertToDTO).toList();}
}
