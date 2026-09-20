package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface EquipmentRepository extends JpaRepository<Equipment,Long> { List<Equipment> findByIsActiveTrue(); Optional<Equipment> findByIdAndIsActiveTrue(Long id); List<Equipment> findByOilFieldIdAndIsActiveTrue(Long oilFieldId); }
