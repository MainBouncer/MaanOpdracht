package travel.model;

import org.junit.Test;
import travel.administration.DataCreator;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class VehicleTest {
    @Test
    public void testMultipleBookings() {
        List<Vehicle> vehicles = DataCreator.createVehicles();
        List<Cargo> cargos = DataCreator.createRandomCargoList(70);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new PersonCallable(cargos, vehicles));
        }

        executorService.shutdown();

        vehicles.forEach(vehicle -> vehicle.getCargoList().forEach(System.out::println));
    }

    class PersonCallable implements Callable<Boolean> {
        List<Cargo> cargos;
        List<Vehicle> vehicles;

        public PersonCallable(List<Cargo> cargos, List<Vehicle> vehicles) {
            this.cargos = cargos;
            this.vehicles = vehicles;
        }

        @Override
        public Boolean call() throws Exception {
            for (Vehicle vehicle: vehicles) {
                cargos.removeIf(vehicle::loadCargo);
            }
            return true;
        }
    }

}