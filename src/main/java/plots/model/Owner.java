package plots.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.permit.AbstractPermit;
import plots.model.plots.AbstractPlot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Owner  implements Serializable {
    private String name;
    private Set<AbstractPlot> ownedPlots;
    private List<AbstractPermit> permits;

    @Builder
    public Owner(String name) {
        this.name = name;
        ownedPlots = new HashSet<>();
        permits = new ArrayList<>();
    }

    public void addPlot(AbstractPlot plot) {
        ownedPlots.add(plot);
    }

    public void addPermit(AbstractPermit permit) {
        permits.add(permit);
    }

}
