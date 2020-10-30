package plots.model;

import org.junit.jupiter.api.Test;
import plots.administration.DataCreator;
import plots.model.exception.PermitNotPossibleUncheckedException;
import plots.model.exception.UnexpectedValueException;

import java.util.List;

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

    @Test
    void multiThreadTest() throws UnexpectedValueException, InterruptedException {
        List<Mineral> mineralList = DataCreator.createMinerals();
        Thread thread1 = new Thread(new CaseChanger(mineralList, true));
        Thread thread2 = new Thread(new CaseChanger(mineralList, false));

        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        for (Mineral mineral : mineralList) {
            System.out.println(mineral.getName());
        }
    }

    class CaseChanger implements Runnable {
        List<Mineral> mineralList;
        boolean toUpperCase;

        public CaseChanger(List<Mineral> mineralList, boolean toUpperCase) {
            this.mineralList = mineralList;
            this.toUpperCase = toUpperCase;
        }

        @Override
        public void run() {
            for (Mineral mineral : mineralList) {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                }

                if (toUpperCase) {
                    mineral.setName(mineral.getName().toUpperCase());
                } else {
                    mineral.setName(mineral.getName().toLowerCase());
                }
            }
        }
    }

}