package plots.administration;

import plots.enums.Crop;
import plots.model.Mineral;
import plots.model.Transfer;
import plots.model.permit.CropPermit;
import plots.model.permit.MineralPermit;
import plots.model.plots.AbstractPlot;
import plots.model.plots.FarmingPlot;
import plots.model.plots.MiningPlot;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.stream.Collectors;

public class MoonPolice {

    private static final String BASE_PATH = "./output";
    private static final String INPUT_PATH = BASE_PATH + "/transfers.txt";
    private static final String OUTPUT_PATH = BASE_PATH + "/illegaltransfers.txt";

    public MoonPolice() {
        List<Transfer> transfers = readTransfers();
        System.out.println(transfers);

        List<Transfer> illegalTransfers = getIllegalTransfers(transfers);

        illegalTransfers.stream()
                .map(this::createBulletin)
                .forEach(System.out::println);

        saveIllegalTransfers(illegalTransfers);
    }

    private List<Transfer> getIllegalTransfers(List<Transfer> transfers) {
        return transfers.stream()
                .filter(transfer -> transfer.getPlot().getAbstractPermit() != null)
                .filter(transfer -> !newOwnerHasRequiredPermit(transfer))
                .collect(Collectors.toList());
    }

    private List<Transfer> readTransfers() {
        List<Transfer> transfers;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(INPUT_PATH))) {
            transfers = (List<Transfer>) objectInputStream.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return transfers;
    }

    private void saveIllegalTransfers(List<Transfer> illegalTransfers) {
        try (ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream(OUTPUT_PATH))) {
            objectInputStream.writeObject(illegalTransfers);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    private boolean newOwnerHasRequiredPermit(Transfer transfer) {
        AbstractPlot plot = transfer.getPlot();
        if (plot instanceof FarmingPlot) {
            // get crop
            Crop crop = ((FarmingPlot) plot).getCrop();
            return transfer.getNewOwner()
                    .getPermits()
                    .stream()
                    .filter(permit -> permit instanceof CropPermit)
                    .map(permit -> (CropPermit) permit)
                    .anyMatch(permit -> permit.getCrop().equals(crop));


        } else if (plot instanceof MiningPlot) {
            // get mineral
            Mineral mineral = ((MiningPlot) plot).getMineral();
            return transfer.getNewOwner()
                    .getPermits()
                    .stream()
                    .filter(permit -> permit instanceof MineralPermit)
                    .map(permit -> (MineralPermit) permit)
                    .anyMatch(permit -> permit.getMineral().equals(mineral));
        } else {
            // why is there permit required? weird
            return true;
        }
    }

    private String createBulletin(Transfer transfer) {
        String substance;
        AbstractPlot plot = transfer.getPlot();

        if (plot instanceof FarmingPlot) {
            // get crop
            substance = ((FarmingPlot) plot).getCrop().getName();
        } else if (plot instanceof MiningPlot) {
            // get mineral
            substance = ((MiningPlot) plot).getMineral().getName();
        } else {
            // why is there permit required? weird
            return "ERROR " + plot.getClass() + " plot unexpected";
        }

        return "Owner " + transfer.getNewOwner()
                .getName() + " was found guilty of not having a permit for " + substance;
    }
}
