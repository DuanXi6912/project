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

import com.vissfot.project.DTO.DepartmentDTO;
import com.vissfot.project.Model.Departments;
import com.vissfot.project.Service.DepartmentService;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("departments")
    public List<DepartmentDTO> getDepartments(){
        return departmentService.getDepartments();
    }
    @GetMapping("departments/{departmentID}")
    public DepartmentDTO getDepartmentByID(@PathVariable int departmentID){
        return departmentService.getDepartmentByID(departmentID);
    }
    @PostMapping("/departments")
    public String createDepartment(@RequestBody Departments department){
        return departmentService.createDepartment(department);
    }
    @PutMapping("/departments")
    public String updateDepartment(@RequestBody Departments department){
        return departmentService.updateDepartment(department);
    }
    @DeleteMapping("/departments/{departmentID}")
    public String deleteDepartmentByID(@PathVariable int departmentID){
        return departmentService.deleteDepartment(departmentID);
    }
}
