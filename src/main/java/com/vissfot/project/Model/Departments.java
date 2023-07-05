package com.vissfot.project.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "departments")
@Data
public class Departments {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentID;
    @Column(name = "department_name")
    private String departmentName;
    //@Column(name = "location_id")
    //private int locationID;

    @ManyToOne(targetEntity = Locations.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Locations location;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employees> employees;

}
