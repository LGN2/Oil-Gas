package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface ShipmentRepository extends JpaRepository<Shipment,Long> { List<Shipment> findByIsActiveTrue(); Optional<Shipment> findByIdAndIsActiveTrue(Long id); List<Shipment> findByStorageTankIdAndIsActiveTrue(Long tankId); }
