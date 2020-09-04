package plots.model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.enums.Crop;
import plots.model.Border;
import plots.model.Owner;
import plots.model.permit.AbstractPermit;
import plots.model.permit.CropPermit;

import java.util.Optional;

@Getter
@Setter
public class FarmingPlot extends AbstractPlot {
    private Crop crop;
    private long cropPerYear;


    @Builder
    public FarmingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Crop crop, long cropPerYear, Optional<CropPermit> permit) {
        super(size, id, location, border, owner, sellable, permit);
        this.crop = crop;
        this.cropPerYear = cropPerYear;
    }

    public Long getCalorieValue(){
        return getCropPerYear() * getCrop().getCalories();
    }

    @Override
    public String toString() {
        return "FarmingPlot{" +
                "crop=" + crop +
                ", cropPerYear=" + cropPerYear +
                '}';
    }
}
