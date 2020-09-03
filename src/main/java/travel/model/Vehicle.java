package travel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import travel.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class Vehicle {

    private int maxCargoSize;
    private int maxPassengerSize;
    private List<Cargo> cargoList;
    private List<String> passengers;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this(vehicleType, 10, 15);
    }

    public Vehicle(VehicleType vehicleType, int maxCargoSize, int maxPassengerSize) {
        this(new ArrayList<>(), new ArrayList<>(), vehicleType, maxCargoSize, maxPassengerSize);
    }

    public Vehicle(List<Cargo> cargoList, List<String> passengers, VehicleType vehicleType, int maxCargoSize, int maxPassengerSize) {
        if (cargoList == null || passengers == null) {
            throw new IllegalArgumentException("No null lists!");
        }
        if (cargoList.size() > maxCargoSize || passengers.size() > maxPassengerSize) {
            throw new IllegalArgumentException("Your passed list is bigger than allowed, dumby.");
        }
        this.cargoList = cargoList;
        this.passengers = passengers;
        this.vehicleType = vehicleType;
        this.maxCargoSize = maxCargoSize;
        this.maxPassengerSize = maxPassengerSize;
    }

    public boolean enterPassenger(String passengerName) {
        if (passengers.size() >= maxPassengerSize) {
            return false;
        }
        return passengers.add(passengerName);
    }

    public boolean leavePassenger(String passengerName) {
        return passengers.remove(passengerName);
    }

    public boolean loadCargo(Cargo cargo) {
        if (cargoList.size() >= maxCargoSize) {
            return false;
        }
        return cargoList.add(cargo);
    }

    public boolean unloadCargo(Cargo cargo) {
        return cargoList.remove(cargo);
    }
}
