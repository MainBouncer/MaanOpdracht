package model.plots;

import lombok.Getter;
import lombok.Setter;
import model.Border;
import model.Owner;

import java.util.List;

@Getter
@Setter
public class LivingPlot extends AbstractPlot {
    private List<Integer> ages;

    public LivingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, List<Integer> ages) {
        super(size, id, location, border, owner, sellable);
        this.ages = ages;
    }
}
