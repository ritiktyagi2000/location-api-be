package com.springboot.locationapi.entity;


import com.springboot.locationapi.constants.LocationType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Location_Entity_Table")
@Data
@NoArgsConstructor
public class LocationEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="Location_Id")
private Long id;

@Enumerated(EnumType.STRING)
private LocationType locationType;
private String plotNo;
private String street;
private String city;
private String state;
private String country;
private Long userId;
private Long openCloseTimeId;
private Long offeringId;
private String lat;
private String lng;

}
