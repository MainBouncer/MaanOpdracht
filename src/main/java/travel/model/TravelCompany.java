package travel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TravelCompany {
    private List<Voyage> voyageList;
    private List<Vehicle> vehicleList;

    public TravelCompany(List<Voyage> voyageList, List<Vehicle> vehicleList) {
        this.voyageList = voyageList;
        this.vehicleList = vehicleList;
    }
}
