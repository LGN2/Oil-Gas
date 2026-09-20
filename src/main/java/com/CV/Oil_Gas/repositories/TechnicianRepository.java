package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface TechnicianRepository extends JpaRepository<Technician,Long> { List<Technician> findByIsActiveTrue(); Optional<Technician> findByIdAndIsActiveTrue(Long id); }
