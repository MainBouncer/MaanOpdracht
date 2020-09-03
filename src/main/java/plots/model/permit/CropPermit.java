package plots.model.permit;

import lombok.Builder;
import plots.enums.Crop;
import plots.model.plots.AbstractPlot;

import java.time.LocalDate;

public class CropPermit extends AbstractPermit {
    private Crop crop;

    @Builder
    public CropPermit(AbstractPlot plot, LocalDate startDate, LocalDate endDate, String operator, Crop crop) {
        super(plot, startDate, endDate, operator);
        this.crop = crop;
    }
}
