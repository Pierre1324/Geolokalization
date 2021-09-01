package org.geolocalization;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class RestClientTest {

    @Mock
    private RestTemplate restTemplate;

    @Autowired
    private RestClient restClient;
    @Autowired
    private LocationRepository locationRepository;

    private LocationDto mockedLocation;


    @BeforeEach
    void setUp() {
        mockedLocation = new LocationDto(12345, 505430, 1423412);
        Mockito.when(restTemplate.getForObject("", LocationDto.class)).thenReturn(mockedLocation);
    }

    @Test
    void getLocationFromNetwork() {
        LocationDto locationFromNetwork = restClient.getLocationFromNetwork("", restTemplate);
        Assertions.assertThat(locationFromNetwork).isEqualTo(mockedLocation);
    }

    @Test
    void fetchAndSaveLocation() {
        restClient.fetchAndSaveLocation("", restTemplate);
        List<LocationEntity> allLocations = locationRepository.findAll();
        Optional<LocationEntity> optionalLocation = allLocations.stream().filter(location ->
                location.getDeviceId() == mockedLocation.getDeviceId() && location.getLatitude() == mockedLocation.getLatitude() && location.getLongitude() == mockedLocation.getLongitude()
        ).findAny();
        Assertions.assertThat(optionalLocation.get()).isNotNull();
    }
}