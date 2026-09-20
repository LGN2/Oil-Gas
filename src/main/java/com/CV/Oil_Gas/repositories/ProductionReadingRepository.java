package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.ProductionReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface ProductionReadingRepository extends JpaRepository<ProductionReading,Long> { List<ProductionReading> findByIsActiveTrue(); Optional<ProductionReading> findByIdAndIsActiveTrue(Long id); List<ProductionReading> findByWellIdAndIsActiveTrue(Long wellId); }
