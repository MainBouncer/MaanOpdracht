package plots.model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.Border;
import plots.model.Owner;
import plots.model.exception.UnexpectedValueException;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class LivingPlot extends AbstractPlot {
    private List<Integer> ages;

    @Builder
    public LivingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, List<Integer> ages) throws UnexpectedValueException {
        super(size, id, location, border, owner, sellable, Optional.empty());
        this.ages = ages;
    }
}
