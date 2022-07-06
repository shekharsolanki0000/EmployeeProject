package com.project.Employee.controller;

import com.project.Employee.entity.Employee;
import com.project.Employee.error.EmployeeNotFoundException;
import com.project.Employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        log.info("Inside saveEmployee method of EmployeeController");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/")
    public List<Employee> fetchEmployeesList() {
        log.info("Inside fetchEmployeesList method of EmployeeController");
        return employeeService.fetchEmployeesList("Active");
    }

    @GetMapping("/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        log.info("Inside fetchEmployeeById method of EmployeeController");
        return employeeService.fetchEmployeeById(employeeId);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
        log.info("Inside deleteEmployeeById method of EmployeeController");
        employeeService.deleteEmployeeById(employeeId);
        return "Employee Deleted Successfully !!!";
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Long employeeId,
                                   @RequestBody Employee employee) throws EmployeeNotFoundException {
        log.info("Inside updateEmployee method of EmployeeController");
        return employeeService.updateEmployee(employeeId, employee);
    }

    @GetMapping("/names/{name}")
    public List<Employee> fetchEmployeeByName(@PathVariable("name") String employeeName){
        log.info("Inside fetchEmployeeByName method of EmployeeController");
        return employeeService.fetchEmployeeByName(employeeName);
    }

    @DeleteMapping("/softdelete/{id}")
    public String softDeleteEmployee(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        log.info("Inside softDeleteEmployee method of EmployeeController");
        employeeService.softDeleteEmployee(employeeId);
        return "Employee Soft Deleted Successfully !!!";
    }
}
