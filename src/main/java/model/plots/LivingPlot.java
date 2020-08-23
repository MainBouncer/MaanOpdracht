package model.plots;

import lombok.Getter;
import lombok.Setter;
import model.Border;
import model.Owner;

@Getter
@Setter
public class LivingPlot extends AbstractPlot {
    private long amountPeople;

    public LivingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, long amountPeople) {
        super(size, id, location, border, owner, sellable);
        this.amountPeople = amountPeople;
    }
}
