package plots.model.plots;

import static org.junit.jupiter.api.Assertions.assertThrows;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import plots.enums.Crop;
import plots.model.exception.PermitRequiredException;
import plots.model.exception.UnexpectedValueException;
import plots.model.permit.CropPermit;

import java.util.Arrays;
import java.util.Optional;

class FarmingPlotTest {

    @Test
    void builder_shouldThrowUnexpectedValueExceptionIfSizeIsZero() {
        assertThrows(UnexpectedValueException.class, () -> FarmingPlot.builder().size(0).build());
    }

    @Test
    void builder_shouldThrowUnexpectedValueExceptionIfSizeIsLowerThanZero() {
        assertThrows(UnexpectedValueException.class, () -> FarmingPlot.builder().size(-1).build());
    }

    @Test
    void builder_shouldNotThrowUnexpectedValueExceptionIfSizeIsBiggerThanZero() throws UnexpectedValueException, PermitRequiredException {
        FarmingPlot.builder().size(1).build();
    }

    @Test
    void builder_shouldThrowPermitRequiredExceptionIfNoRequiredPermitForCrop() {
        Arrays.stream(Crop.values())
                .filter(Crop::isPermitRequired)
                .forEach(crop -> assertThrows(PermitRequiredException.class, () -> FarmingPlot.builder()
                        .size(1)
                        .crop(crop)
                        .permit(null)
                        .build()));
    }

    @Test
    void builder_shouldNotThrowPermitRequiredExceptionIfNoRequiredPermitForCrop() {
        Arrays.stream(Crop.values())
                .filter(Crop::isPermitRequired)
                .forEach(this::canCreateFarmingPlotWithPermit);
    }

    @SneakyThrows
    private void canCreateFarmingPlotWithPermit(Crop crop) {
        FarmingPlot.builder()
                .size(1)
                .crop(crop)
                .permit(CropPermit.builder().build())
                .build();
    }

}