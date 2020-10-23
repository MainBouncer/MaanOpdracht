package plots.administration;

import plots.model.Transfer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class MoonPolice {
    public MoonPolice() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./output/transfers.txt")) ) {
            List<Transfer> transfers = (List<Transfer>) objectInputStream.readObject();

            System.out.println(transfers);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
