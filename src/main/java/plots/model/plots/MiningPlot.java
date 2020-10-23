package plots.model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.Border;
import plots.model.Mineral;
import plots.model.Owner;
import plots.model.exception.PermitRequiredException;
import plots.model.exception.UnexpectedValueException;
import plots.model.permit.MineralPermit;

import java.util.Optional;

@Getter
@Setter
public class MiningPlot extends AbstractPlot {
    private Mineral mineral;
    private long mineralPerYear;

    @Builder
    public MiningPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Mineral mineral, long mineralPerYear, MineralPermit permit)
            throws UnexpectedValueException, PermitRequiredException {
        super(size, id, location, border, owner, sellable, permit);

        if (mineral != null && mineral.isPermitRequired() && permit == null) {
            throw new PermitRequiredException();
        }
        this.mineral = mineral;
        this.mineralPerYear = mineralPerYear;
    }
}
