package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface ContractorRepository extends JpaRepository<Contractor,Long> { List<Contractor> findByIsActiveTrue(); Optional<Contractor> findByIdAndIsActiveTrue(Long id); }
