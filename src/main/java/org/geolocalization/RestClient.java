package org.geolocalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    private final LocationService locationService;

    @Autowired
    public RestClient(LocationService locationService) {
        this.locationService = locationService;
    }

    public void fetchAndSaveLocation(String url, RestTemplate restTemplate){
        LocationDto locationFromNetwork = getLocationFromNetwork(url, restTemplate);
        locationService.saveLocation(locationFromNetwork);
    }

    public LocationDto getLocationFromNetwork(String url, RestTemplate restTemplate){
        return restTemplate.getForObject(url, LocationDto.class);
    }
}
