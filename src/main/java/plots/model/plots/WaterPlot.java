package plots.model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.Border;
import plots.model.Owner;
import plots.model.exception.UnexpectedValueException;

import java.util.Optional;

@Getter
@Setter
public class WaterPlot extends AbstractPlot {
    private long waterPerYear;

    @Builder
    public WaterPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, long waterPerYear) throws UnexpectedValueException {
        super(size, id, location, border, owner, sellable, null);
        this.waterPerYear = waterPerYear;
    }
}
