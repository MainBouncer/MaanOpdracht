package plots.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class Border implements Serializable {
    private List<Long> coordinates;

    public Border(List<Long> coordinates) {
        this.coordinates = coordinates;
    }
}
