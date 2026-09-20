package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.OilField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface OilFieldRepository extends JpaRepository<OilField,Long> { List<OilField> findByIsActiveTrue(); Optional<OilField> findByIdAndIsActiveTrue(Long id); }
