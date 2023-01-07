package com.springboot.locationapi.service;

import com.springboot.locationapi.model.LocationModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
@Service
public interface LocationService {
    public List<LocationModel> getALlLocations(Long userId);

    public boolean createLocations( LocationModel locationModel) throws URISyntaxException;

    public LocationModel updateLocation(Long locationId,LocationModel locationModel, Long userId);

    public boolean deleteLocation(Long locationId,Long userId);
}
