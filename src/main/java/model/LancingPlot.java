package model;

public class LancingPlot extends AbstractPlot {
    long rocketSize;

    public LancingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, long rocketSize) {
        super(size, id, location, border, owner, sellable);
        this.rocketSize = rocketSize;
    }
}
