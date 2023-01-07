package com.springboot.locationapi.apiclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GeoCodeResponseWrapper {
    @JsonProperty("data")
    private List<GeoCodeResponse>geocodeList;

}
