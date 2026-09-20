package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.StorageTank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface StorageTankRepository extends JpaRepository<StorageTank,Long> { List<StorageTank> findByIsActiveTrue(); Optional<StorageTank> findByIdAndIsActiveTrue(Long id); List<StorageTank> findByOilFieldIdAndIsActiveTrue(Long oilFieldId); }
