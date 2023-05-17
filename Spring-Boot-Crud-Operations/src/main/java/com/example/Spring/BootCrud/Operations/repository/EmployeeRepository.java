package com.example.Spring.BootCrud.Operations.repository;

import com.example.Spring.BootCrud.Operations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
