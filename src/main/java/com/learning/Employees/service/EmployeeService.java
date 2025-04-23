package com.learning.Employees.service;

import com.learning.Employees.dto.EmployeeDTO;
import com.learning.Employees.entity.EmployeesEntity;
import com.learning.Employees.exception.RequestValidationException;
import com.learning.Employees.repository.EmployeeRepository;
import com.learning.Employees.validation.EmployeeValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeesEntity addEmployee(EmployeeDTO employeeDTO) {

        EmployeeValidations.validateEmployee(employeeDTO);

        EmployeesEntity employee = new EmployeesEntity();
        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setPhonenumber(employeeDTO.getPhonenumber());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAddress(employeeDTO.getAddress());

        return employeeRepository.save(employee);
    }

    public EmployeesEntity updateEmployee(String employeeId, EmployeeDTO employeeDTO) {

        EmployeesEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RequestValidationException("Employee not found", HttpStatus.NOT_FOUND));

        EmployeeValidations.validateEmployee(employeeDTO);

        if (employeeDTO.getFirstname() != null) {
            employee.setFirstname(employeeDTO.getFirstname());
        }
        if (employeeDTO.getLastname() != null) {
            employee.setLastname(employeeDTO.getLastname());
        }
        if (employeeDTO.getPhonenumber() != null) {
            employee.setPhonenumber(employeeDTO.getPhonenumber());
        }
        if (employeeDTO.getEmail() != null) {
            employee.setEmail(employeeDTO.getEmail());
        }
        if (employeeDTO.getAddress() != null) {
            employee.setAddress(employeeDTO.getAddress());
        }

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String employeeId) {
        EmployeesEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->new RequestValidationException("Employee not found" , HttpStatus.NOT_FOUND));
        employeeRepository.delete(employee);
    }

    public EmployeesEntity getEmployee(String employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RequestValidationException("Employees not found", HttpStatus.NOT_FOUND));
    }

    public Page<EmployeesEntity> getAllEmployees(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }
}
