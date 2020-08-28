package travel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import travel.enums.CargoType;

@Getter
@Setter
@Builder
public class Cargo {
    private CargoType cargoType;
    private long volume;
    private long weight;
    private boolean perishable;

    public Cargo(CargoType cargoType, long volume, long weight, boolean perishable) {
        this.cargoType = cargoType;
        this.volume = volume;
        this.weight = weight;
        this.perishable = perishable;
    }
}
