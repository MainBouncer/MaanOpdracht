package model.plots;

import enums.Mineral;
import model.Border;
import model.Owner;

public class MiningPlot extends AbstractPlot {
    Mineral mineral;
    long mineralPerYear;

    public MiningPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Mineral mineral, long mineralPerYear) {
        super(size, id, location, border, owner, sellable);
        this.mineral = mineral;
        this.mineralPerYear = mineralPerYear;
    }
}
