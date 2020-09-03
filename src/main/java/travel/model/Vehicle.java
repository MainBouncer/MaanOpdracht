package travel.model;

import lombok.Getter;
import lombok.Setter;
import travel.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Vehicle {

    private int maxCargoSize;
    private List<Cargo> cargoList;
    private String[] passengers;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this(vehicleType, 10, 15);
    }

    public Vehicle(VehicleType vehicleType, int maxCargoSize, int maxPassengerSize) {
        this(new ArrayList<>(), vehicleType, maxCargoSize, maxPassengerSize);
    }

    public Vehicle(List<Cargo> cargoList, VehicleType vehicleType, int maxCargoSize, int maxPassengerSize) {
        if (cargoList == null) {
            throw new IllegalArgumentException("No null lists!");
        }
        if (cargoList.size() > maxCargoSize) {
            throw new IllegalArgumentException("Your passed list is bigger than allowed, dumby.");
        }
        this.cargoList = cargoList;
        this.passengers = new String[maxPassengerSize];
        this.vehicleType = vehicleType;
        this.maxCargoSize = maxCargoSize;
    }

    public boolean reserveSpot(int position, String passengerName) {
        if (position >= 0 && position < passengers.length) {
            if (passengers[position] != null) {
                return false;
            }
            passengers[position] = passengerName;
            return true;
        }
        return false;
    }

    public boolean enterPassenger(String passengerName) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = passengerName;
                return true;
            }
        }
        return false;
    }

    public boolean leavePassenger(String passengerName) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i].equals(passengerName)) {
                passengers[i] = null;
                return true;
            }
        }
        return false;
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
