package model;

import enums.Mineral;
import lombok.AllArgsConstructor;
import lombok.Builder;

public class MiningPlot extends AbstractPlot {
    Mineral mineral;
    long mineralPerYear;

    public MiningPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Mineral mineral, long mineralPerYear) {
        super(size, id, location, border, owner, sellable);
        this.mineral = mineral;
        this.mineralPerYear = mineralPerYear;
    }
}
