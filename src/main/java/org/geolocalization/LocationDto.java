package org.geolocalization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class LocationDto {

    private int deviceId;
    private double latitude;
    private double longitude;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationDto location = (LocationDto) o;
        return deviceId == location.deviceId && Double.compare(location.latitude, latitude) == 0 && Double.compare(location.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, latitude, longitude);
    }
}
