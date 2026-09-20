package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.MaintenanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord,Long> { List<MaintenanceRecord> findByIsActiveTrue(); Optional<MaintenanceRecord> findByIdAndIsActiveTrue(Long id); List<MaintenanceRecord> findByEquipmentIdAndIsActiveTrue(Long equipmentId); }
