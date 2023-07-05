package com.vissfot.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vissfot.project.Model.Dependents;
import com.vissfot.project.Repository.DependentRepo;

@Service
public class DependentService {
    @Autowired
    private DependentRepo dependentRepo;

    public List<Dependents> getDependents(){
        return dependentRepo.findAll();
    }

    public Dependents getDependentByID(int dependentID){
        int index = getIndexByID(dependentID);
        if(index != -1){
            return getDependents().get(index);
        }
        return null;
    }

    public String createDependent(Dependents dependent){
        boolean canCreate = validDependent(dependent);
        if(canCreate){
            dependentRepo.save(dependent);
            return "Create New Dependent";
        }
        return "Fail For Create Dependent";
    }

    public String updateDependent(Dependents dependent){
        int index = getIndexByID(dependent.getDependentID());
        if(index != -1){
            boolean canUpdate = validDependent(dependent);
            if(canUpdate){
                dependentRepo.save(dependent);
                return "Update Dependent";
            }
        }
        return "Fail For Update Dependent";
    }

    public String deleteDependentByID(int depeendentID){
        Dependents dependentFound = getDependentByID(depeendentID);
        if(dependentFound != null){
            dependentRepo.delete(dependentFound);
            return "Delete Dependent ID = " + depeendentID;
        }
        return "Fail For Delete Dependent";
    }
    
    // Supplement Method
    private int getIndexByID(int dependentID){
        int index = 0;
        for(Dependents dependentFound : getDependents()){
            if(dependentID == dependentFound.getDependentID()){
                return index;
            }
            index++;
        }
        return -1;
    }

    private boolean validDependent(Dependents dependent){
        for(Dependents dependentFound: getDependents()){
            if(dependent.getFirstName().equals(dependentFound.getFirstName())
            && dependent.getLastName().equals(dependentFound.getLastName())
            && dependent.getRelationship().equals(dependentFound.getRelationship())
            ){
                return false;
            }
        }
        return true;
    }
    

}
