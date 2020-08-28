package plots.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.plots.AbstractPlot;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Transfer {

    private long id;
    private Owner newOwner;
    private Owner oldOwner;
    private LocalDate date;
    private AbstractPlot plot;

}
