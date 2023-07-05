package com.vissfot.project.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vissfot.project.DTO.EmployeeDTO;
import com.vissfot.project.Model.Employees;
import com.vissfot.project.Repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmployeeDTO> getEmployees() {
        List<Employees> employees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employees employee : employees) {
            EmployeeDTO employeeDTO = new EmployeeDTO(employee);
            employeeDTOs.add(employeeDTO);
        }
        return employeeDTOs;
    }

    public EmployeeDTO getEmployeeByID(int employee_id) {
        int index = getIndexByID(employee_id);
        if (index != -1) {
            EmployeeDTO employeeDTO = new EmployeeDTO(employeeRepo.findAll().get(index));
            return employeeDTO;
        }
        return null;
    }

    public String createEmployee(Employees employee) {
        boolean canCreate = validEmployee(employee, -1);
        if(canCreate){
            employeeRepo.save(employee);
            return "Create New Employee";
        }
        return "Fail For Create New Employee";
    }

    public String updateEmployee(Employees employee){
        int index = getIndexByID(employee.getEmployeeID());
        if(index != -1){
            boolean canUpdate = validEmployee(employee, employee.getEmployeeID());
            if(canUpdate){
                employeeRepo.save(employee);
                return "Update Employee";
            }
        }
        return "Fail For Update Employee";
    }

    public String deleteEmployeeByID(int employee_id){
        int index = getIndexByID(employee_id);
        if(index != -1){
            Employees employeeFound = employeeRepo.findAll().get(index);
            employeeRepo.delete(employeeFound);
            return "Delete Employee ID = " + employee_id;
        }
        return "Fail For Delete Employee";
    }
    
    // Supplement Method
    private int getIndexByID(int employee_id) {
        List<Employees> employees = employeeRepo.findAll();
        int index = 0;
        for (Employees employee : employees) {
            if (employee_id == employee.getEmployeeID()) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private boolean validEmployee(Employees employee, int employeeID){
        boolean valid = false;
        // Email - unique ?
        String email = employee.getEmail();
        // min <= salary <= max
        Double salary = employee.getSalary();
        Double minS = employee.getJob().getMinSalary();
        Double maxS = employee.getJob().getMaxSalary();
        
        // Check Salary First
        if(salary >= minS && salary <= maxS){
            // Kiểm tra email là duy nhất 
            List<Employees> employees = employeeRepo.findAll();
            for(Employees employeeFound : employees){
                if(employeeID == employeeFound.getEmployeeID()){
                    continue;
                }
                if(email.equals(employeeFound.getEmail())){
                    return valid;
                }
            }
            valid = true;
        }
        return valid;
    }

}
