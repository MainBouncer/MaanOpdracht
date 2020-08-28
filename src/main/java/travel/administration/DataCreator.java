package travel.administration;

import travel.enums.CargoType;
import travel.enums.VehicleType;
import travel.model.Cargo;
import travel.model.Station;
import travel.model.TravelCompany;
import travel.model.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataCreator {

    public static List<Station> createStations() {
        return Arrays.asList(
                Station.builder().name("station 1").build(),
                Station.builder().name("station 2").build(),
                Station.builder().name("station 3").build(),
                Station.builder().name("station 4").build(),
                Station.builder().name("station 5").build()
        );
    }

    public static List<Cargo> createRandomCargoList(int size) {
        List<Cargo> cargoList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cargoList.add(createRandomCargo());
        }
        return cargoList;
    }

    public static Cargo createRandomCargo() {
        Random random = new Random();
        return Cargo.builder()
                .cargoType(CargoType.getRandomCargoType())
                .perishable(random.nextBoolean())
                .volume(random.nextInt(50))
                .weight(random.nextInt(500))
                .build();
    }

    public static List<Vehicle> createVehicles() {
        return Arrays.asList(
                new Vehicle(VehicleType.ROCKET),
                new Vehicle(VehicleType.MONORAIL),
                new Vehicle(VehicleType.MONORAIL),
                new Vehicle(VehicleType.TRAIN),
                new Vehicle(VehicleType.TRAIN)
        );
    }

    public static List<TravelCompany> createCompanies() {
        return Arrays.asList(
                TravelCompany.builder()
                        .name("company 1")
                        .vehicleList(createVehicles())
                        .voyageList(new ArrayList<>())
                        .build(),
                TravelCompany.builder()
                        .name("company 2")
                        .vehicleList(createVehicles())
                        .voyageList(new ArrayList<>())
                        .build(),
                TravelCompany.builder()
                        .name("company 3")
                        .vehicleList(createVehicles())
                        .voyageList(new ArrayList<>())
                        .build()
        );
    }

}
