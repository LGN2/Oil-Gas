package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Rig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface RigRepository extends JpaRepository<Rig,Long> { List<Rig> findByIsActiveTrue(); Optional<Rig> findByIdAndIsActiveTrue(Long id); List<Rig> findByContractorIdAndIsActiveTrue(Long contractorId); }
