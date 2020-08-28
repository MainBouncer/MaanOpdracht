package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class Mineral {
    private final String name;
    private final long number;
    private final long density;
    private final boolean isRadioActive;

    public Mineral(String name, long number, long density, boolean isRadioActive) {
        this.name = name;
        this.number = number;
        this.density = density;
        this.isRadioActive = isRadioActive;
    }
}
