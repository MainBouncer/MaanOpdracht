package plots.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.model.exception.IncorrectTransferException;
import plots.model.plots.AbstractPlot;

import java.time.LocalDate;

@Getter
@Setter
public class Transfer {

    private long id;
    private Owner newOwner;
    private Owner oldOwner;
    private LocalDate date;
    private AbstractPlot plot;

    @Builder
    public Transfer(long id, Owner newOwner, Owner oldOwner, LocalDate date, AbstractPlot plot) throws IncorrectTransferException {
        if (newOwner == null || oldOwner == null || newOwner.equals(oldOwner)) {
            throw new IncorrectTransferException();
        }

        this.id = id;
        this.newOwner = newOwner;
        this.oldOwner = oldOwner;
        this.date = date;
        this.plot = plot;
    }
}
