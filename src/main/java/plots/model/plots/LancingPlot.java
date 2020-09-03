package plots.model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.Border;
import plots.model.Owner;

import java.util.Optional;

@Getter
@Setter
public class LancingPlot extends AbstractPlot {
    private long rocketSize;

    @Builder
    public LancingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, long rocketSize) {
        super(size, id, location, border, owner, sellable, Optional.empty());
        this.rocketSize = rocketSize;
    }
}
