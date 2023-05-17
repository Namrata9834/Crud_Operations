package com.example.Spring.BootCrud.Operations.controller;

import com.example.Spring.BootCrud.Operations.model.Employee;
import com.example.Spring.BootCrud.Operations.service.EmployeeService;
import com.example.Spring.BootCrud.Operations.service.impls.EmployeeServiceImpls;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    // build  create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }

    // build get all employee REST API
   @GetMapping
   public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
   }

   // build get employee by id REST API
    //http://localhost/api/employee/1
    @GetMapping("{id}")
    private ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){

        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    // build to update employee REST API
   // http://localhost/api/employee/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long id
                                                   ,@RequestBody Employee employee){
    return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);

}

// build to delete employee REST API
   // http://localhost/api/employee/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfullly..",HttpStatus.OK);

    }
}