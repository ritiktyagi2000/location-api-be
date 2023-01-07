package com.springboot.locationapi.mapper;

import com.springboot.locationapi.entity.LocationEntity;
import com.springboot.locationapi.model.LocationModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {
    LocationMapper INSTANCE= Mappers.getMapper(LocationMapper.class);
 LocationModel convertEntityToModel(LocationEntity locationEntity);
    LocationEntity convertModeltoEntity(LocationModel locationModel);

}
