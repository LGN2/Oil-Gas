package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface PersonnelRepository extends JpaRepository<Personnel,Long> { List<Personnel> findByIsActiveTrue(); Optional<Personnel> findByIdAndIsActiveTrue(Long id); List<Personnel> findByContractorIdAndIsActiveTrue(Long contractorId); List<Personnel> findByOilFieldIdAndIsActiveTrue(Long oilFieldId); }
