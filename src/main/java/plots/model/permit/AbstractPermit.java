package plots.model.permit;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.plots.AbstractPlot;

import java.time.LocalDate;

@Setter
@Getter
public class AbstractPermit {
    private AbstractPlot plot;
    private LocalDate startDate;
    private LocalDate endDate;
    private String operator;

    public AbstractPermit(AbstractPlot plot, LocalDate startDate, LocalDate endDate, String operator) {
        this.plot = plot;
        this.startDate = startDate;
        this.endDate = endDate;
        this.operator = operator;
    }
}
