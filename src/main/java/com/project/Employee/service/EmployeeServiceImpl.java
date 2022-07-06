package com.project.Employee.service;

import com.project.Employee.entity.Employee;
import com.project.Employee.error.EmployeeNotFoundException;
import com.project.Employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    String status = "Active";

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        log.info("Inside saveEmployee method of EmployeeServiceImpl");
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeesList(String status) {
        log.info("Inside fetchEmployeesList method of EmployeeServiceImpl");
        return employeeRepository.findByStatusIgnoreCase(status);
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        log.info("Inside fetchEmployeeById method of EmployeeServiceImpl");
        Optional<Employee> employee = employeeRepository.findByEmployeeIdAndStatusIgnoreCase(employeeId, status);
        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException("Employee not available");
        }
        return employee.get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        log.info("Inside deleteEmployeeById method of EmployeeServiceImpl");
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) throws EmployeeNotFoundException {
        log.info("Inside updateEmployee method of EmployeeServiceImpl");
        Optional<Employee> empVO = employeeRepository.findByEmployeeIdAndStatusIgnoreCase(employeeId, status);
        if (!empVO.isPresent()) {
            throw new EmployeeNotFoundException("Employee not available");
        }
        Employee emp = empVO.get();

        if (Objects.nonNull(employee.getEmpName()) &&
                !"".equalsIgnoreCase(employee.getEmpName())) {
            emp.setEmpName(employee.getEmpName());
        }
        if (Objects.nonNull(employee.getEmpDesignation()) &&
                !"".equalsIgnoreCase(employee.getEmpDesignation())) {
            emp.setEmpDesignation(employee.getEmpDesignation());
        }
        if (Objects.nonNull(employee.getEmpAddress()) &&
                !"".equalsIgnoreCase(employee.getEmpAddress())) {
            emp.setEmpAddress(employee.getEmpAddress());
        }
        if (Objects.nonNull(employee.getEmpEmailId()) &&
                !"".equalsIgnoreCase(employee.getEmpEmailId())) {
            emp.setEmpEmailId(employee.getEmpEmailId());
        }
        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> fetchEmployeeByName(String employeeName) {
        log.info("Inside fetchEmployeeByName method of EmployeeServiceImpl");
        return employeeRepository.findByEmpNameIgnoreCase(employeeName);
    }

    @Override
    public void softDeleteEmployee(Long employeeId) throws EmployeeNotFoundException {
        log.info("Inside softDeleteEmployee method of EmployeeServiceImpl");
        Optional<Employee> empVO = employeeRepository.findByEmployeeIdAndStatusIgnoreCase(employeeId, status);
        if (!empVO.isPresent()) {
            throw new EmployeeNotFoundException("Employee not available");
        }
        String status = "Deactive";
        Employee emp = empVO.get();
        emp.setStatus(status);
        employeeRepository.save(emp);
    }
}
