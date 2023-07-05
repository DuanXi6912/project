package com.vissfot.project.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vissfot.project.DTO.DepartmentDTO;
import com.vissfot.project.Model.Departments;
import com.vissfot.project.Repository.DepartmentRepo;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public List<DepartmentDTO> getDepartments(){
        List<Departments> departments = departmentRepo.findAll();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();
        for(Departments department : departments){
            DepartmentDTO departmentDTO = new DepartmentDTO(department);
            departmentDTOs.add(departmentDTO);
        }
        return departmentDTOs;
    }

    public DepartmentDTO getDepartmentByID(int departmentID){
        int index = getIndexByID(departmentID);
        if(index != -1){
            return getDepartments().get(index);
        }
        return null;
    }

    public String createDepartment(Departments department){
        boolean valid = uniqueCheck(department.getDepartmentName(), department.getLocation().getLocationID(), -1);
        if(valid){
            departmentRepo.save(department);
            return "Create New Department";
        }
        return "Fail For Create New Department";
    }

    public String updateDepartment(Departments department){
        int index = getIndexByID(department.getDepartmentID());
        if(index != -1){
            // Check unique
            boolean valid = uniqueCheck(department.getDepartmentName(), department.getLocation().getLocationID(), department.getDepartmentID());
            if(valid){
                departmentRepo.save(department);
                return "Update Department";
            }
            return "Missinformation Department";
        }
        return "Fail For Update Department";
    }

    public String deleteDepartment(int departmentID){
        Departments departmentFound = departmentRepo.findAll().get(getIndexByID(departmentID));
        if(departmentFound != null){
            departmentRepo.delete(departmentFound);
            return "Delete Department ID = " + departmentID;
        }
        return "Fail For Delete Department";
    }

    // Supplement Method
    private int getIndexByID(int departmentID){
        List<Departments> departments = departmentRepo.findAll();
        int index = 0;
        for(Departments departmentFound : departments){
            if(departmentID == departmentFound.getDepartmentID()){
                return index;
            }
            index++;
        }
        return -1;
    }

    private boolean uniqueCheck(String departmentName, int locationID, int departmentID){
        List<Departments> departments = departmentRepo.findAll();
        for(Departments departmentFound : departments){
            if(departmentID == departmentFound.getDepartmentID()){
                continue;
            }
            if(departmentName.equals(departmentFound.getDepartmentName())
               && locationID == departmentFound.getLocation().getLocationID()){
                return false;
            }
        }
        return true;
    }

}
