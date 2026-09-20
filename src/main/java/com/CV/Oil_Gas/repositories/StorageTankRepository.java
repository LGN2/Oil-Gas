package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.StorageTank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface StorageTankRepository extends JpaRepository<StorageTank,Long> { List<StorageTank> findByIsActiveTrue(); Optional<StorageTank> findByIdAndIsActiveTrue(Long id); List<StorageTank> findByOilFieldIdAndIsActiveTrue(Long oilFieldId);  @org.springframework.data.jpa.repository.Query("select t from StorageTank t where t.isActive=true and t.currentLevel >= t.capacity * 0.9") List<StorageTank> findAboveNinetyPercent(); }
