package travel.enums;

import java.util.Random;

public enum CargoType {
    SOLID,
    LIQUID,
    GAS;

    public static CargoType getRandomCargoType() {
        Random random = new Random();
        return CargoType.values()[random.nextInt(CargoType.values().length)];
    }

    private void doSomething() throws Exception {

    }
}
