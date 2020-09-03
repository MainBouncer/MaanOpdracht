package plots.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class Mineral {
    private final String name;
    private final long number;
    private final long density;
    private final boolean isRadioActive;
    private final boolean isPermitRequired;

    public Mineral(String name, long number, long density, boolean isRadioActive, boolean isPermitRequired) {
        this.name = name;
        this.number = number;
        this.density = density;
        this.isRadioActive = isRadioActive;
        this.isPermitRequired = isPermitRequired;
    }
}
