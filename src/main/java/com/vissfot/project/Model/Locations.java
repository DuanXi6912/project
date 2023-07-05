package com.vissfot.project.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "locations")
@Data
public class Locations {
    @Id
    @Column(name = "location_id")
    private int locationID;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state_province")
    private String stateProvince;
   // @Column(name = "region_id", nullable = false)
   // private int regionID;
    
    
    @ManyToOne(targetEntity = Regions.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Regions region;

    
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    private List<Departments> departments;
}
