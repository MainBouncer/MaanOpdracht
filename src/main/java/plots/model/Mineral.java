package plots.model;

import lombok.Builder;
import lombok.Getter;
import plots.model.exception.PermitNotPossibleUncheckedException;
import plots.model.exception.UnexpectedValueException;

import java.io.Serializable;

@Getter
public final class Mineral implements Serializable {
    private String name;
    private final long number;
    private final long density;
    private final boolean isRadioActive;
    private final boolean isPermitRequired;

    @Builder
    public Mineral(String name, long number, long density, boolean isRadioActive, boolean isPermitRequired) throws UnexpectedValueException {
        assert name != null;

        if (number == 0 || density == 0) {
            throw new UnexpectedValueException();
        }

        if (isRadioActive && isPermitRequired) {
            throw new PermitNotPossibleUncheckedException();
        }

        this.name = name;
        this.number = number;
        this.density = density;
        this.isRadioActive = isRadioActive;
        this.isPermitRequired = isPermitRequired;
    }

    public void setName(String name) {
        this.name = name;
    }
}
