package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface IncidentRepository extends JpaRepository<Incident,Long> { List<Incident> findByIsActiveTrue(); Optional<Incident> findByIdAndIsActiveTrue(Long id); List<Incident> findByOilFieldIdAndIsActiveTrue(Long oilFieldId); List<Incident> findByStatusIgnoreCaseAndIsActiveTrue(String status); }
