package model.plots;

import enums.Crop;
import model.Border;
import model.Owner;


public class FarmingPlot extends AbstractPlot {
    Crop crop;
    long cropPerYear;

    public FarmingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Crop crop, long cropPerYear) {
        super(size, id, location, border, owner, sellable);
        this.crop = crop;
        this.cropPerYear = cropPerYear;
    }
}
