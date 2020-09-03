package plots.model.permit;

import plots.enums.Crop;
import plots.model.plots.AbstractPlot;

import java.time.LocalDate;

public class CropPermit extends AbstractPermit {
    private Crop crop;

    CropPermit(AbstractPlot plot, LocalDate startDate, LocalDate endDate, String Operator) {
        super(plot, startDate, endDate, Operator);
    }

    public CropPermit(AbstractPlot plot, LocalDate startDate, LocalDate endDate, String Operator, Crop crop) {
        super(plot, startDate, endDate, Operator);
        this.crop = crop;
    }
}
