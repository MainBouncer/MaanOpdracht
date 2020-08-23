package model.plots;

import enums.Crop;
import lombok.Getter;
import lombok.Setter;
import model.Border;
import model.Owner;

@Getter
@Setter
public class FarmingPlot extends AbstractPlot {
    private Crop crop;
    private long cropPerYear;

    public FarmingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Crop crop, long cropPerYear) {
        super(size, id, location, border, owner, sellable);
        this.crop = crop;
        this.cropPerYear = cropPerYear;
    }
}
