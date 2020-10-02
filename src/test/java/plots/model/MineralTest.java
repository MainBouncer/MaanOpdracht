package plots.model;

import org.junit.jupiter.api.Test;
import plots.model.exception.PermitNotPossibleUncheckedException;
import plots.model.exception.UnexpectedValueException;

import static org.junit.jupiter.api.Assertions.*;

class MineralTest {

    @Test
    void checkForValidInput() {
        assertThrows(UnexpectedValueException.class, () -> Mineral.builder().name("Helium-3").density(0).isRadioActive(true).number(65).build());
    }

    @Test
    void checkForRuntimeException() {
        assertThrows(
                PermitNotPossibleUncheckedException.class,
                () -> Mineral.builder().name("Helium-3").number(65).density(1).isPermitRequired(true).isRadioActive(true).build()
        );
    }

    @Test
    void checkJavaAssert() throws UnexpectedValueException {
        assertThrows(
                AssertionError.class,
                () -> Mineral.builder().build()
        );
    }
}