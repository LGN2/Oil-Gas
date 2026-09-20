package com.CV.Oil_Gas.controllers;
import com.CV.Oil_Gas.dto.*; import com.CV.Oil_Gas.services.OperationsService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.web.bind.annotation.*; import java.math.BigDecimal; import java.time.LocalDate; import java.util.*;
@RestController @RequestMapping("/operations") @RequiredArgsConstructor
public class OperationsController {
 private final OperationsService service;
 @PostMapping("/wells/{wellId}/production") public ProductionReadingDTO production(@PathVariable Long wellId,@Valid @RequestBody ProductionReadingDTO dto){return service.recordProduction(wellId,dto);}
 @PutMapping("/wells/{wellId}/rig/{rigId}") public WellDTO assignRig(@PathVariable Long wellId,@PathVariable Long rigId){return service.assignRig(wellId,rigId);}
 @PutMapping("/tanks/{tankId}/transfer") public StorageTankDTO transfer(@PathVariable Long tankId,@RequestParam BigDecimal volume){return service.transferToTank(tankId,volume);}
 @PostMapping("/shipments/dispatch") public ShipmentDTO dispatch(@Valid @RequestBody ShipmentDTO dto){return service.dispatch(dto);}
 @PostMapping("/maintenance") public MaintenanceRecordDTO maintenance(@Valid @RequestBody MaintenanceRecordDTO dto,@RequestParam(defaultValue="MAINTENANCE") String equipmentStatus){return service.logMaintenance(dto,equipmentStatus);}
 @GetMapping("/equipment/{id}/maintenance") public List<MaintenanceRecordDTO> maintenance(@PathVariable Long id){return service.maintenanceForEquipment(id);}
 @PostMapping("/inspections") public InspectionDTO inspection(@Valid @RequestBody InspectionDTO dto){return service.scheduleInspection(dto);}
 @PostMapping("/incidents") public IncidentDTO incident(@Valid @RequestBody IncidentDTO dto){return service.reportIncident(dto);}
 @GetMapping("/incidents/open") public List<IncidentDTO> open(@RequestParam(required=false) String severity){return service.openIncidents(severity);}
 @GetMapping("/fields/{id}/production") public Map<String,Object> production(@PathVariable Long id,@RequestParam LocalDate start,@RequestParam LocalDate end){return Map.of("fieldId",id,"totalOilVolume",service.totalOil(id,start,end));}
 @GetMapping("/wells/producing") public List<WellDTO> producing(){return service.producingWells();}
 @GetMapping("/tanks/above-90-percent") public List<StorageTankDTO> tanks(){return service.tanksAbove90();}
 @GetMapping("/pipelines/due-inspection") public List<PipelineDTO> pipelinesDue(){return service.pipelinesDueForInspection();}
 @GetMapping("/equipment/maintenance-cost-ranking") public List<EquipmentDTO> equipmentCost(){return service.equipmentByMaintenanceCost();}
 @GetMapping("/fields/{id}/stats") public Map<String,Object> fieldStats(@PathVariable Long id){return service.fieldStats(id);}
 @GetMapping("/contractors/{id}/stats") public Map<String,Object> contractorStats(@PathVariable Long id){return service.contractorStats(id);}
}