package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface InspectorRepository extends JpaRepository<Inspector,Long> { List<Inspector> findByIsActiveTrue(); Optional<Inspector> findByIdAndIsActiveTrue(Long id); }
