package org.geolocalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationRepository locationRepository;


    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public int saveLocation(LocationDto locationDto){
        LocationEntity locationEntity = new LocationEntity(locationDto.getDeviceId(), locationDto.getLatitude(), locationDto.getLongitude());
        LocationEntity savedLocation = locationRepository.save(locationEntity);
        return savedLocation.getId();
    }
}
