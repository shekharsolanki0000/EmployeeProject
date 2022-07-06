package com.project.Employee.service;

import com.project.Employee.entity.Employee;
import com.project.Employee.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> fetchEmployeesList(String status);

    Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;

    void deleteEmployeeById(Long employeeId);

    Employee updateEmployee(Long employeeId, Employee employee) throws EmployeeNotFoundException;

    List<Employee> fetchEmployeeByName(String employeeName);

    void softDeleteEmployee(Long employeeId) throws EmployeeNotFoundException;
}
