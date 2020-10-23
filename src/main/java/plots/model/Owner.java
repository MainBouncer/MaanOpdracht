package plots.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.plots.AbstractPlot;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Owner  implements Serializable {
    private String name;
    private Set<AbstractPlot> ownedPlots;

    @Builder
    public Owner(String name) {
        this.name = name;
        ownedPlots = new HashSet<>();
    }

    public void addPlot(AbstractPlot plot) {
        ownedPlots.add(plot);
    }

}
