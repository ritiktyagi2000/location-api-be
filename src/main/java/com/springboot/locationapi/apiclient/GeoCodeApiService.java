package com.springboot.locationapi.apiclient;

import com.springboot.locationapi.model.LocationModel;
import com.springboot.locationapi.service.LocationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Slf4j
@Service
public class GeoCodeApiService {


    @Value("${geocode.api.baseurl}")
    private String apiBaseUrl;
    @Value("${geocode.api.key}")
    private String apiKey;

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;
    private static Logger LOGGER =  LoggerFactory.getLogger(GeoCodeApiService.class);
    @Cacheable(cacheNames = "geoCodeCache",key = "#locationModel.userId")
    public void getCoordinates(LocationModel locationModel){
    StringBuilder apiUrl=new StringBuilder();
    apiUrl.append(apiBaseUrl);
    apiUrl.append("?access_key=");
    apiUrl.append(apiKey);
    apiUrl.append("&query=");
    if(locationModel.getStreet()!=null) {
        apiUrl.append(locationModel.getStreet());
        apiUrl.append(" ");
    }
    if(locationModel.getStreet()!=null) {
        apiUrl.append(locationModel.getCity());
        apiUrl.append(" ");
    }
    if(locationModel.getStreet()!=null) {
        apiUrl.append(locationModel.getCountry());
    }
    LOGGER.warn("the full api url is {} ",apiUrl);
    try {
        GeoCodeResponseWrapper responseWrapper = restTemplate.getForObject(apiUrl.toString(), GeoCodeResponseWrapper.class);
        GeoCodeResponse geoCodeResponse = responseWrapper.getGeocodeList().get(0);
        if (responseWrapper.getGeocodeList() != null && !responseWrapper.getGeocodeList().isEmpty()) {
            locationModel.setLat(geoCodeResponse.getLatitude().toString());
            locationModel.setLng(geoCodeResponse.getLongitude().toString());
        }
    }catch (Exception e){
        LOGGER.error("Error occured while connecting to geocode api at {}",apiUrl);
    }

}

}
