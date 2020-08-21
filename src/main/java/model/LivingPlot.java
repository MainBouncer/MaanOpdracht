package model;

import lombok.AllArgsConstructor;
import lombok.Builder;


public class LivingPlot extends AbstractPlot {
    long amountPeople;

    public LivingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, long amountPeople) {
        super(size, id, location, border, owner, sellable);
        this.amountPeople = amountPeople;
    }
}
