package com.example.Spring.BootCrud.Operations.service.impls;

import com.example.Spring.BootCrud.Operations.exception.ResourceNotFoundException;
import com.example.Spring.BootCrud.Operations.model.Employee;
import com.example.Spring.BootCrud.Operations.repository.EmployeeRepository;
import com.example.Spring.BootCrud.Operations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpls implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpls(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
     Optional<Employee>  employee=employeeRepository.findById(id);
     if(employee.isPresent()){
         return employee.get();
     } else {
         throw new ResourceNotFoundException("Employee","Id",id);
     }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // we need to check whether employee with given id is exist in database or not

        Employee existingEmployee=employeeRepository.findById( id).orElseThrow(
            ()-> new ResourceNotFoundException("Employee","Id",id));
         existingEmployee.setFirstName(employee.getFirstName());
         existingEmployee.setLastName(employee.getLastName());
         existingEmployee.setEmail(employee.getEmail());

         employeeRepository.save(existingEmployee);
         return existingEmployee;
        }

    @Override
    public void deleteEmployee(long id) {

        // check whether a employee exist in the database or not

        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);

    }
}




