package plots.model.permit;

import lombok.Builder;
import plots.model.Mineral;
import plots.model.plots.AbstractPlot;

import java.time.LocalDate;

public class MineralPermit extends AbstractPermit {
    private Mineral mineral;

    @Builder
    public MineralPermit(AbstractPlot plot, LocalDate startDate, LocalDate endDate, String operator, Mineral mineral) {
        super(plot, startDate, endDate, operator);
        this.mineral = mineral;
    }
}
