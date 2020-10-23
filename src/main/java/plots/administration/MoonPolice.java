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
import java.io.ObjectInputStream;
import java.util.List;
import java.util.stream.Collectors;

public class MoonPolice {

    public MoonPolice() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./output/transfers.txt"))) {
            List<Transfer> transfers = (List<Transfer>) objectInputStream.readObject();

            System.out.println(transfers);

            List<Transfer> illegalTransfers = transfers.stream()
                    .filter(transfer -> transfer.getPlot().getAbstractPermit() != null)
                    .filter(transfer -> !newOwnerHasRequiredPermit(transfer))
                    .collect(Collectors.toList());
            List<String> bulletins = illegalTransfers.stream()
                    .map(this::createBulletin)
                    .collect(Collectors.toList());

            bulletins.forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
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
