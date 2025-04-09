package com.learning.Employees.controller;

import com.learning.Employees.dto.EmployeeDTO;
import com.learning.Employees.entity.EmployeesEntity;
import com.learning.Employees.service.EmployeeService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/AddEmployee")

    public ResponseEntity<EmployeesEntity> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeesEntity savedEmployee = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/updateEmployee/{id}")

    public ResponseEntity<EmployeesEntity> updateemployee(@PathVariable String id,@RequestBody  EmployeeDTO employeeDTO){
        EmployeesEntity updatedEmployee = employeeService.updateEmployee(id,employeeDTO);
                return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/getAllemployee")

    public ResponseEntity<Page<EmployeesEntity>>getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size){
        Page<EmployeesEntity> employees = employeeService.getAllEmployees(page, size);
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/getemployee/{id}")
    public ResponseEntity<EmployeesEntity>getEmployeeById(@PathVariable String id){
        EmployeesEntity getEmployee = employeeService.getEmployee(id);
        return ResponseEntity.ok(getEmployee);
    }


    @DeleteMapping("/deletemployee/{id}")
    public  ResponseEntity<String>deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee with ID " + id + " deleted successfully.");


    }



}
