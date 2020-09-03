package plots.model.permit;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.plots.AbstractPlot;

import java.time.LocalDate;

@Setter
@Getter
@Builder
public abstract class AbstractPermit {
    private AbstractPlot plot;
    private LocalDate startDate;
    private LocalDate endDate;
    private String Operator;

}
