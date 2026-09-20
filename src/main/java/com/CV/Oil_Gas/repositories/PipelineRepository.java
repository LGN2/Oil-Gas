package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Pipeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface PipelineRepository extends JpaRepository<Pipeline,Long> { List<Pipeline> findByIsActiveTrue(); Optional<Pipeline> findByIdAndIsActiveTrue(Long id); List<Pipeline> findByOilFieldIdAndIsActiveTrue(Long oilFieldId); }
