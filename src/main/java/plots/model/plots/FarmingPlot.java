package plots.model.plots;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import plots.enums.Crop;
import plots.model.Border;
import plots.model.Owner;
import plots.model.exception.PermitRequiredException;
import plots.model.exception.UnexpectedValueException;
import plots.model.permit.CropPermit;

@Getter
@Setter
public class FarmingPlot extends AbstractPlot {
    private Crop crop;
    private long cropPerYear;

    @Builder
    public FarmingPlot(long size, long id, String location, Border border, Owner owner, boolean sellable, Crop crop, long cropPerYear, CropPermit permit)
            throws UnexpectedValueException, PermitRequiredException {
        super(size, id, location, border, owner, sellable, permit);

        if (crop != null && crop.isPermitRequired() && permit == null) {
            throw new PermitRequiredException();
        }

        this.crop = crop;
        this.cropPerYear = cropPerYear;
    }

    public Long getCalorieValue() {
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
