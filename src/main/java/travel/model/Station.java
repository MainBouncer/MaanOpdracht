package travel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }
}
