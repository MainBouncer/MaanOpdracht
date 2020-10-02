package plots.model;

import org.junit.jupiter.api.Test;
import plots.model.exception.UnExpectedValueException;

import static org.junit.jupiter.api.Assertions.*;

class MineralTest {

    @Test
    void checkForValidInput() {
        assertThrows(UnExpectedValueException.class, () -> plots.model.Mineral.builder().name("Helium-3").density(0).isRadioActive(true).number(65).build());
    }
}