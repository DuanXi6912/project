package com.vissfot.project.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "regions")
@Data
public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private int regionID;
    @Column(name = "region_name")
    private String regionName;

    @JsonIgnore // Do không có DTO để xử lý khi GET :> 
    @OneToMany(mappedBy = "region", 
               fetch = FetchType.LAZY,
               cascade =  CascadeType.ALL)
    private List<Locations> locations;
}
