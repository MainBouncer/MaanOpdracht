package travel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Voyage {
    private Vehicle vehicle;
    private Station stationFrom;
    private Station stationTo;
    private LocalDateTime departureTime;

    public Voyage(Vehicle vehicle, Station stationFrom, Station stationTo, LocalDateTime departureTime) {
        this.vehicle = vehicle;
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.departureTime = departureTime;
    }
}
