package com.project.Employee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "NAME")
    @NotBlank(message = "Please provide employee name")
    private String empName;

    @Column(name = "DESIGNATION")
    @NotBlank(message = "Please provide employee designation")
    private String empDesignation;

    @Column(name = "ADDRESS")
    @NotBlank(message = "Please provide employee address")
    private String empAddress;

    @Column(name = "EMAIL_ID")
    @NotBlank(message = "Please provide employee email id")
    private String empEmailId;

    @Column(name = "DATE_OF_BIRTH")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date empDOB;
}
