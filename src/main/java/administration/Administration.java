package administration;

import enums.Crop;
import lombok.Getter;
import model.Border;
import model.Owner;
import model.Transfer;
import model.plots.AbstractPlot;
import model.plots.FarmingPlot;
import model.plots.LivingPlot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class Administration {

    private static Administration INSTANCE;

    private List<AbstractPlot> abstractPlots;
    private List<Owner> owners;
    private List<Border> borders;
    private List<Transfer> transfers;

    private Administration() {
        owners = DataCreator.createOwners();
        borders = DataCreator.createBorders();
        abstractPlots = DataCreator.createPlots(borders, owners);

        transfers = new ArrayList<>();
        abstractPlots.forEach(ap -> transfers.addAll(DataCreator.createTransfers(ap, owners)));

        abstractPlots.forEach(ap -> {
            Owner owner = ap.getOwner();
            owner.addPlot(ap);
        });
    }

    public static Administration getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Administration();
        }
        return INSTANCE;
    }

    public Map<LivingPlot, Integer> getNumberOfPeopleOver30PerPlot() {
        List<LivingPlot> livingPlots = abstractPlots.stream()
                .filter(plot -> plot instanceof LivingPlot)
                .map(plot -> (LivingPlot) plot)
                .collect(Collectors.toList());

        Map<LivingPlot, Integer> map = new HashMap<>();
        for (LivingPlot plot : livingPlots) {
            int amountOver30 = (int) plot.getAges().stream().filter(i -> i >= 30).count();
            map.put(plot, amountOver30);
        }
        return map;
    }

    public Map<Crop, Double> getAverageCropsValue() {
        Map<Crop, List<FarmingPlot>> collect = abstractPlots.stream()
                .filter(plot -> plot instanceof FarmingPlot)
                .map(plot -> (FarmingPlot) plot)
                .collect(Collectors.groupingBy(FarmingPlot::getCrop));

        Map<Crop, Double> averageCropValue = new HashMap<>();

        for (Crop crop : Crop.values()) {
            double average = collect.get(crop).stream()
                    .map(FarmingPlot::getCropPerYear)
                    .mapToLong(Long::longValue)
                    .average()
                    .orElse(0.0);
            averageCropValue.put(crop, average);
        }
        return averageCropValue;
    }

    public int getAmountOfPlotsOfType(Class<? extends AbstractPlot> clazz) {
        return (int) abstractPlots.stream()
                .filter(clazz::isInstance)
                .count();
    }

    public long getPlotsSoldPerPeriod(LocalDate startDate, LocalDate endDate) {
        return transfers.stream().filter(transfer -> dateIsInPeriod(startDate, endDate, transfer))
                .map(Transfer::getPlot)
                .collect(Collectors.toSet())
                .size();
    }

    private boolean dateIsInPeriod(LocalDate startDate, LocalDate endDate, Transfer transfer) {
        return (transfer.getDate().isAfter(startDate) || transfer.getDate().equals(startDate)) &&
                (transfer.getDate().isBefore(endDate) || transfer.getDate().equals(endDate));
    }


    public List<AbstractPlot> getPlotsSoldOverAverage() {
        int averageSold = transfers.size() / abstractPlots.size();
        System.out.println("Average sold: " + averageSold);
        return abstractPlots.stream()
                .filter(plot -> getAmountOfTransfersWithPlot(plot) > averageSold)
                .collect(Collectors.toList());
    }

    public List<AbstractPlot> getPlotsSoldUnderAverage() {
        int averageSold = transfers.size() / abstractPlots.size();
        System.out.println("Average sold: " + averageSold);
        return abstractPlots.stream()
                .filter(plot -> getAmountOfTransfersWithPlot(plot) < averageSold)
                .collect(Collectors.toList());
    }

    private int getAmountOfTransfersWithPlot(AbstractPlot plot) {
        return (int) transfers.stream().filter(transfer -> plot.equals(transfer.getPlot())).count();
    }

    public List<FarmingPlot> getFarmingPlotsWithGoodProduction() {
        double averageCropValue = getAverageCropValue();
        return abstractPlots.stream()
                .filter(plot -> plot instanceof FarmingPlot)
                .map(plot -> (FarmingPlot) plot)
                .filter(plot -> plot.getCropPerYear() > averageCropValue)
                .collect(Collectors.toList());
    }

    private double getAverageCropValue() {
        double average = abstractPlots.stream()
                .filter(plot -> plot instanceof FarmingPlot)
                .map(plot -> (FarmingPlot) plot)
                .map(FarmingPlot::getCropPerYear)
                .mapToLong(Long::longValue)
                .average()
                .orElseThrow(() -> new IllegalStateException("No FarmingPlots in the system"));
        System.out.println("Average crop value is " + average);
        return average;
    }
}
