package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Pipeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface PipelineRepository extends JpaRepository<Pipeline,Long> { List<Pipeline> findByIsActiveTrue(); Optional<Pipeline> findByIdAndIsActiveTrue(Long id); List<Pipeline> findByOilFieldIdAndIsActiveTrue(Long oilFieldId);  @org.springframework.data.jpa.repository.Query("select p from Pipeline p where p.isActive=true and not exists (select i.id from Inspection i where i.isActive=true and i.pipeline=p and i.inspectionDate >= :cutoff)") List<Pipeline> findDueForInspection(@org.springframework.data.repository.query.Param("cutoff") java.time.LocalDate cutoff); }
