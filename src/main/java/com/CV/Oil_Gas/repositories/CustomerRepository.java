package com.CV.Oil_Gas.repositories;
import com.CV.Oil_Gas.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository public interface CustomerRepository extends JpaRepository<Customer,Long> { List<Customer> findByIsActiveTrue(); Optional<Customer> findByIdAndIsActiveTrue(Long id); }
