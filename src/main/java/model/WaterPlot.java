package model;

import lombok.AllArgsConstructor;
import lombok.Builder;


public class WaterPlot extends AbstractPlot {
    long waterPerYear;

    public WaterPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, long waterPerYear) {
        super(size, id, location, border, owner, sellable);
        this.waterPerYear = waterPerYear;
    }
}
