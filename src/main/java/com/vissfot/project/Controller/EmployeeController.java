package com.vissfot.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vissfot.project.DTO.EmployeeDTO;
import com.vissfot.project.Model.Employees;
import com.vissfot.project.Service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/employees/{employeeID}")
    public EmployeeDTO getEmployeeByID(@PathVariable int employeeID){
        return employeeService.getEmployeeByID(employeeID);
    }
    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employees employee){
        return employeeService.createEmployee(employee);
    }
    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employees employee){
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployeeByID(@PathVariable int employeeID){
        return employeeService.deleteEmployeeByID(employeeID);
    }
}
