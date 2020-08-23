package model;

import lombok.Getter;
import lombok.Setter;
import model.plots.AbstractPlot;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Owner {
    private String name;
    private Set<AbstractPlot> ownedPlots;

    public Owner(String name) {
        this.name = name;
        ownedPlots = new HashSet<>();
    }

    public void addPlot(AbstractPlot plot) {
        ownedPlots.add(plot);
    }

}
