package travel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TravelCompany {
    private String name;
    private List<Voyage> voyageList;
    private List<Vehicle> vehicleList;

    public TravelCompany(String name, List<Voyage> voyageList, List<Vehicle> vehicleList) {
        this.name = name;
        this.voyageList = voyageList;
        this.vehicleList = vehicleList;
    }
}
