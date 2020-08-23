package model;

import model.plots.AbstractPlot;

import java.time.ZonedDateTime;

public class Transfer {
    long id;
    Owner newOwner;
    Owner oldOwner;
    ZonedDateTime date;
    AbstractPlot plot;
    
}
