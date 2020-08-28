package travel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import travel.enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class Vehicle {
    private List<Cargo> cargoList;
    private Map<Integer, String> passengers;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        cargoList = new ArrayList<>();
        passengers = new HashMap<>();
    }

    public Vehicle(List<Cargo> cargoList, Map<Integer, String> passengers, VehicleType vehicleType) {
        this.cargoList = cargoList;
        this.passengers = passengers;
        this.vehicleType = vehicleType;
    }
}
