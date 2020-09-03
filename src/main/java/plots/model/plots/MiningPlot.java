package plots.model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.Border;
import plots.model.Mineral;
import plots.model.Owner;
import plots.model.permit.AbstractPermit;
import plots.model.permit.MineralPermit;

import java.util.Optional;

@Getter
@Setter
public class MiningPlot extends AbstractPlot {
    private Mineral mineral;
    private long mineralPerYear;

    @Builder
    public MiningPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Mineral mineral, long mineralPerYear, Optional<MineralPermit> permit) {
        super(size, id, location, border, owner, sellable, permit);
        this.mineral = mineral;
        this.mineralPerYear = mineralPerYear;
    }
}
