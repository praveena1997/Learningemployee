package com.learning.Employees.repository;
import com.learning.Employees.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeesEntity, String> {
}
