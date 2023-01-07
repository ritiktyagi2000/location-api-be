package com.springboot.locationapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.locationapi.constants.LocationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationModel {
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
