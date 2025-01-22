package com.javaguides.Springbootbackend.repository;


import com.javaguides.Springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Employee,Long> {
    // all crud methods
}

