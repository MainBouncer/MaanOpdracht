package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Border {
    private List<Long> coordinates;

    public Border(List<Long> coordinates) {
        this.coordinates = coordinates;
    }
}
