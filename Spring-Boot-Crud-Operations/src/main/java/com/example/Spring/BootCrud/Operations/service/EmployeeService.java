package com.example.Spring.BootCrud.Operations.service;

import com.example.Spring.BootCrud.Operations.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
     Employee saveEmployee(Employee employee);
   List<  Employee> getAllEmployee();
   Employee getEmployeeById (long id);
   Employee updateEmployee(Employee employee,long id)   ;
   void deleteEmployee(long id);
}
