package model;

import lombok.Getter;
import lombok.Setter;
import model.plots.AbstractPlot;

import java.time.ZonedDateTime;

@Getter
@Setter
public class Transfer {

    private long id;
    private Owner newOwner;
    private Owner oldOwner;
    private ZonedDateTime date;
    private AbstractPlot plot;

}
