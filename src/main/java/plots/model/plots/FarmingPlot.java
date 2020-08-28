package plots.model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.enums.Crop;
import plots.model.Border;
import plots.model.Owner;

@Getter
@Setter
public class FarmingPlot extends AbstractPlot {
    private Crop crop;
    private long cropPerYear;

    @Builder
    public FarmingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Crop crop, long cropPerYear) {
        super(size, id, location, border, owner, sellable);
        this.crop = crop;
        this.cropPerYear = cropPerYear;
    }
}
