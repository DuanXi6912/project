package com.vissfot.project.DTO;

import com.vissfot.project.Model.Employees;

public class EmployeeDTO {
    private int employeeID;
    private String employeeName;
    private String employeeEmail;
    private String employeeJob;
    private String employeeDepartment;


    public EmployeeDTO(Employees employee) {
        this.employeeID = employee.getEmployeeID();
        this.employeeName = employee.getFirstName() + " " + employee.getLastName();
        this.employeeEmail = employee.getEmail();
        this.employeeJob = employee.getJob().getJobTitle();
        this.employeeDepartment = employee.getDepartment().getDepartmentName();
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return this.employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeJob() {
        return this.employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    public String getEmployeeDepartment() {
        return this.employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }


}
