package plots.model.plots;

import lombok.Getter;
import lombok.Setter;
import plots.model.Border;
import plots.model.Owner;
import plots.model.exception.UnexpectedValueException;
import plots.model.permit.AbstractPermit;

import java.util.Optional;

@Getter
@Setter
public abstract class AbstractPlot {
    private long size;
    private long id;
    private String location;
    private Border border;
    private Owner owner;
    private boolean sellable;
    private Optional<? extends AbstractPermit> abstractPermit;

    public AbstractPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Optional<? extends AbstractPermit> abstractPermit) throws UnexpectedValueException {
        if (size <= 0) {
            throw new UnexpectedValueException();
        }

        this.size = size;
        this.id = id;
        this.location = location;
        this.border = border;
        this.owner = owner;
        this.sellable = sellable;
        this.abstractPermit = abstractPermit;
    }
}
