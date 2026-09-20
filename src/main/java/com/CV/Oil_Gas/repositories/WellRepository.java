package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Well;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface WellRepository extends JpaRepository<Well,Long> { List<Well> findByIsActiveTrue(); Optional<Well> findByIdAndIsActiveTrue(Long id); List<Well> findByOilFieldIdAndIsActiveTrue(Long oilFieldId); List<Well> findByStatusIgnoreCaseAndIsActiveTrue(String status); }
