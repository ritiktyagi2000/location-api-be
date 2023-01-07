package com.springboot.locationapi.service;

import com.springboot.locationapi.apiclient.GeoCodeApiService;
import com.springboot.locationapi.apiclient.GeoCodeResponse;
import com.springboot.locationapi.apiclient.GeoCodeResponseWrapper;
import com.springboot.locationapi.entity.LocationEntity;
import com.springboot.locationapi.mapper.LocationMapper;
import com.springboot.locationapi.model.LocationModel;
import com.springboot.locationapi.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private GeoCodeApiService geoCodeApiService;

    private static Logger LOGGER =  LoggerFactory.getLogger(LocationServiceImpl.class);
    @Override
    public List<LocationModel> getALlLocations(Long userId) {
        List<LocationEntity> locationEntityList = locationRepository.findByUserId(userId);
        List<LocationModel>locationModels=new ArrayList<>();
        for(LocationEntity locationEntity:locationEntityList){
            LocationModel locationModel = LocationMapper.INSTANCE.convertEntityToModel(locationEntity);
            locationModels.add(locationModel);
        }
        return locationModels;
    }

    @Override
    public boolean createLocations(LocationModel locationModel)  {
       LOGGER.warn("under create location function");
        geoCodeApiService.getCoordinates(locationModel);
        LocationEntity locationEntity = LocationMapper.INSTANCE.convertModeltoEntity(locationModel);
        LocationEntity location = locationRepository.save(locationEntity);
        if(location!=null){
            return true;
        }
        return false;
    }

    @Override
    public LocationModel updateLocation(Long locationId, LocationModel locationModel, Long userId) {
        return null;
    }

    @Override
    public boolean deleteLocation(Long locationId, Long userId) {
        return false;
    }
}
