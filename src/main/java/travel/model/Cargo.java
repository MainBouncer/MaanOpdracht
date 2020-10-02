package travel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import travel.enums.CargoType;

@Getter
@Setter
@Builder
public class Cargo implements Comparable<Cargo> {

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

    @Override
    public int compareTo(Cargo other) {
        if (other == null) {
            return 1;
        }

        // if either is perishable but the other is not, return -1 or 1
        if (perishable ^ other.perishable) {
            return perishable ? 1 : -1;
        }
        // if neither or both are perishable, continue to compare the rest
        // heavier and bigger items in the back
        if (volume != other.volume) {
            return volume > other.volume ? -1 : 1;
        }
        if (weight != other.weight) {
            return weight > other.weight ? -1 : 1;
        }
        return 0;
    }
}
