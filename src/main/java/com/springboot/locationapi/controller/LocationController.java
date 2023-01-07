package com.springboot.locationapi.controller;

import com.springboot.locationapi.entity.LocationEntity;
import com.springboot.locationapi.model.LocationModel;
import com.springboot.locationapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LocationController {
@Autowired
LocationService locationService;

@GetMapping("/locations/users/{userId}")
public ResponseEntity<List<LocationModel>> getALlLocations(@PathVariable Long userId ){
    List<LocationModel> locations = locationService.getALlLocations(userId);
return new ResponseEntity<>(locations, HttpStatus.OK);
}
@PostMapping("/locations/users")
public ResponseEntity<String> createLocations(@RequestBody LocationModel locationModel) throws URISyntaxException {
    boolean result = locationService.createLocations(locationModel);
    if(result){
        return new ResponseEntity<>("Location created",HttpStatus.OK);
    }else {
        return new ResponseEntity<>("Location could not be created",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
@PutMapping("/location/{locationId}/users/{userId}")
public void updateLocation(@PathVariable Long locationId,
                           @RequestBody LocationModel locationModel,@PathVariable Long userId){

}
@DeleteMapping("/location/{locationId}")
public void deleteLocation(@PathVariable Long locationId,
                           @RequestBody LocationModel locationModel,@PathVariable Long userId){


}

}
