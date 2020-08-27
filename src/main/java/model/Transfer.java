package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.plots.AbstractPlot;

import java.time.LocalDate;
import java.time.ZonedDateTime;

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
