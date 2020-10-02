package plots.model;

import lombok.Builder;
import lombok.Getter;
import plots.model.exception.UnExpectedValueException;

@Getter

public final class Mineral {
    private final String name;
    private final long number;
    private final long density;
    private final boolean isRadioActive;
    private final boolean isPermitRequired;

    @Builder
    public Mineral(String name, long number, long density, boolean isRadioActive, boolean isPermitRequired) throws UnExpectedValueException {
        assert name != null;
        this.name = name;

        if (number == 0 || density == 0) {
            throw new UnExpectedValueException();
        }

        this.number = number;
        this.density = density;
        this.isRadioActive = isRadioActive;
        this.isPermitRequired = isPermitRequired;
    }
}
