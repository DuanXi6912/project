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

import com.vissfot.project.Model.Dependents;
import com.vissfot.project.Service.DependentService;

@RestController
public class DependentController {
    @Autowired
    private DependentService dependentService;

    @GetMapping("/dependents")
    public List<Dependents> getDependents(){
        return dependentService.getDependents();
    }
    @GetMapping("/dependents/{dependentID}")
    public Dependents getDependentByID(@PathVariable int dependentID){
        return dependentService.getDependentByID(dependentID);
    }
    @PostMapping("/dependents")
    public String createDependent(@RequestBody Dependents dependent){
        return dependentService.createDependent(dependent);
    }
    @PutMapping("/dependents")
    public String updateDependent(@RequestBody Dependents dependents){
        return dependentService.updateDependent(dependents);
    }
    @DeleteMapping("/dependents/{dependentID}")
    public String deleteDependentByID(@PathVariable int dependentID){
        return dependentService.deleteDependentByID(dependentID);
    }
}
