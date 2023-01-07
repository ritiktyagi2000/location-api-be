package com.springboot.locationapi.repository;

import com.springboot.locationapi.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Long> {

    List<LocationEntity>findByUserId(Long userId);
}
