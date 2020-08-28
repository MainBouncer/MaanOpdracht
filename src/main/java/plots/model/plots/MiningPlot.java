package plots.model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.Border;
import plots.model.Mineral;
import plots.model.Owner;

@Getter
@Setter
public class MiningPlot extends AbstractPlot {
    private Mineral mineral;
    private long mineralPerYear;

    @Builder
    public MiningPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Mineral mineral, long mineralPerYear) {
        super(size, id, location, border, owner, sellable);
        this.mineral = mineral;
        this.mineralPerYear = mineralPerYear;
    }
}
