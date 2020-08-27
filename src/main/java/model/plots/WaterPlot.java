package model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.Border;
import model.Owner;

@Getter
@Setter
public class WaterPlot extends AbstractPlot {
    private long waterPerYear;

    @Builder
    public WaterPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, long waterPerYear) {
        super(size, id, location, border, owner, sellable);
        this.waterPerYear = waterPerYear;
    }
}
