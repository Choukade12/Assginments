package org.example.repository;

import org.example.model.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<customer,Integer>{
    List<customer> FindByEmail(String email);
}
