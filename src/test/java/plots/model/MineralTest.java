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


//    Maak een lijst met delfstoffen, probeer in de ene thread alle namen van delfstoffen om te zetten naar uppercase en in de andere thread naar lowercase.
//    Laat deze tegelijk lopen.
//    Laat bijvoorbeeld de ene thread van achter naar voren door de lijst lopen en in de andere thread andersom.

    @Test
    void multiThreadTest() throws UnexpectedValueException {
        List<Mineral> mineralList = DataCreator.createMinerals();
        Thread thread1 = new Thread(new CaseChanger(mineralList, true));
        Thread thread2 = new Thread(new CaseChanger(mineralList, false));

        thread1.start();
        thread2.start();

        for(Mineral mineral: mineralList) {
            System.out.println(mineral.getName());
        }
    }

    class CaseChanger implements Runnable{
        List<Mineral> mineralList;
        boolean toUpperCase;

        public CaseChanger(List<Mineral> mineralList, boolean toUpperCase) {
            this.mineralList = mineralList;
            this.toUpperCase = toUpperCase;
        }

        @Override
        public void run() {
            for (Mineral mineral: mineralList) {
                if(toUpperCase) {
                    mineral.setName(mineral.getName().toUpperCase());
                } else {
                    mineral.setName(mineral.getName().toLowerCase());
                }
            }
        }
    }

}