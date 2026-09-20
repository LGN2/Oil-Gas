package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.ProductionReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface ProductionReadingRepository extends JpaRepository<ProductionReading,Long> { List<ProductionReading> findByIsActiveTrue(); Optional<ProductionReading> findByIdAndIsActiveTrue(Long id); List<ProductionReading> findByWellIdAndIsActiveTrue(Long wellId);  @org.springframework.data.jpa.repository.Query("select coalesce(sum(p.oilVolume),0) from ProductionReading p where p.isActive=true and p.well.oilField.id=:fieldId and p.readingDate between :start and :end") java.math.BigDecimal totalOilByFieldAndDateRange(@org.springframework.data.repository.query.Param("fieldId") Long fieldId,@org.springframework.data.repository.query.Param("start") java.time.LocalDate start,@org.springframework.data.repository.query.Param("end") java.time.LocalDate end); }
