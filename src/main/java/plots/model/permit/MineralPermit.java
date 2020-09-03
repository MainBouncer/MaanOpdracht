package plots.model.permit;

import plots.model.Mineral;
import plots.model.plots.AbstractPlot;

import java.time.LocalDate;

public class MineralPermit extends AbstractPermit {
    private Mineral mineral;

    public MineralPermit(AbstractPlot plot, LocalDate startDate, LocalDate endDate, String Operator, Mineral mineral) {
        super(plot, startDate, endDate, Operator);
        this.mineral = mineral;
    }
}
