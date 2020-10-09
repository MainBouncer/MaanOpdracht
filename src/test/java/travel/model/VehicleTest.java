package travel.model;

import org.junit.Test;
import travel.administration.DataCreator;
import travel.enums.CargoType;
import travel.enums.VehicleType;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;


class ThreadExample implements Callable<Boolean> {
    Cargo cargo;
    Vehicle vehicle;

    public ThreadExample(Cargo cargo, Vehicle vehicle) {
        this.cargo = cargo;
        this.vehicle = vehicle;
    }

    @Override
    public Boolean call() throws Exception {
        return vehicle.loadCargo(cargo);
    }
}


class VehicleTest {
    @Test
    public void testMultipleBookings() {
        Vehicle vehicle = new Vehicle(VehicleType.TRAIN);
        List<Cargo> cargo = DataCreator.createRandomCargoList(10);

        ExecutorService e = Executors.newCachedThreadPool();


        cargo.forEach(c -> e.submit(new ThreadExample(c, vehicle)));
        //e.invokeAll();

        e.shutdown();
    }


}