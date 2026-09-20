package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface EquipmentRepository extends JpaRepository<Equipment,Long> { List<Equipment> findByIsActiveTrue(); Optional<Equipment> findByIdAndIsActiveTrue(Long id); List<Equipment> findByOilFieldIdAndIsActiveTrue(Long oilFieldId);  @org.springframework.data.jpa.repository.Query("select e from Equipment e join e.maintenanceRecords m where e.isActive=true and m.isActive=true group by e order by sum(m.cost) desc") List<Equipment> findOrderByMaintenanceCostDesc(); }
