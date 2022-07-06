package com.project.Employee.repository;

import com.project.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeIdAndStatusIgnoreCase(Long employeeId, String status);

    List<Employee> findByEmpNameIgnoreCase(String employeeName);

    List<Employee> findByStatusIgnoreCase(String status);


}
