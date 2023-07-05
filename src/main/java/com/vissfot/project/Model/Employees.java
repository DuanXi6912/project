package com.vissfot.project.Model;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    // @Column(name = "job_id", nullable = false)
    // private int jobID;

    @Column(name = "salary", nullable = false)
    private double salary;
    
    // @Column(name = "manager_id")
    // private Integer managerID;

    //@Column(name = "department_id")
    //private int departmentID;

    @OneToMany(mappedBy = "employeeD", cascade = CascadeType.REMOVE)
    private List<Dependents> dependents;

    @ManyToOne(targetEntity = Departments.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Departments department;


    @ManyToOne(targetEntity = Jobs.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Jobs job;

    @ManyToOne(targetEntity = Employees.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = true)
    private Employees managerEmployee;

    @OneToMany(mappedBy = "managerEmployee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Employees> employeesOfManager;
}
