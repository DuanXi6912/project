package com.vissfot.project.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dependents")
@Data
public class Dependents {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dependent_id")
    private int dependentID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "relationship")
    private String relationship;
    
    @ManyToOne(targetEntity = Employees.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employees employeeD;

}
