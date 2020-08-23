package model.plots;

import enums.Mineral;
import lombok.Getter;
import lombok.Setter;
import model.Border;
import model.Owner;

@Getter
@Setter
public class MiningPlot extends AbstractPlot {
    private Mineral mineral;
    private long mineralPerYear;

    public MiningPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Mineral mineral, long mineralPerYear) {
        super(size, id, location, border, owner, sellable);
        this.mineral = mineral;
        this.mineralPerYear = mineralPerYear;
    }
}
