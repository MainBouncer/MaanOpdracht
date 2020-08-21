package model;

public abstract class AbstractPlot {
    long size;
    long id;
    String location;
    Border border;
    Owner owner;
    boolean sellable;

    public AbstractPlot(long size, long id, String location, Border border, Owner owner, boolean sellable) {
        this.size = size;
        this.id = id;
        this.location = location;
        this.border = border;
        this.owner = owner;
        this.sellable = sellable;
    }
}
