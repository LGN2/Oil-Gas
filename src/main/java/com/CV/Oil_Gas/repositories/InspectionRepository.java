package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface InspectionRepository extends JpaRepository<Inspection,Long> { List<Inspection> findByIsActiveTrue(); Optional<Inspection> findByIdAndIsActiveTrue(Long id); List<Inspection> findByWellIdAndIsActiveTrue(Long wellId); List<Inspection> findByPipelineIdAndIsActiveTrue(Long pipelineId); }
