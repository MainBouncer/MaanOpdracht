package model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.Border;
import model.Owner;

@Getter
@Setter
public class LancingPlot extends AbstractPlot {
    private long rocketSize;

    @Builder
    public LancingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, long rocketSize) {
        super(size, id, location, border, owner, sellable);
        this.rocketSize = rocketSize;
    }
}
