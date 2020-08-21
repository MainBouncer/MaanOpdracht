package model;

import java.time.ZonedDateTime;

public class Transfer {
    long id;
    Owner newOwner;
    Owner oldOwner;
    ZonedDateTime date;
    AbstractPlot plot;
    
}
