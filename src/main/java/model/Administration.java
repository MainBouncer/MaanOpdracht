package model;

import enums.Crop;
import enums.Mineral;
import lombok.Getter;
import model.plots.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Administration {

    private static Administration INSTANCE;

    private List<AbstractPlot> abstractPlots = new ArrayList<>();
    private List<Owner> owners = new ArrayList<>();
    private List<Border> borders = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();

    private Administration() {
        createOwners();
        createBorders();
        createPlots();
        abstractPlots.forEach(this::createTransfers);
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
                .map(plot -> {
                    System.out.println("Plot " + plot.getId() + " had value " + plot.getCropPerYear());
                    return plot.getCropPerYear();
                })
                .mapToLong(Long::longValue)
                .average()
                .orElseThrow(() -> new IllegalStateException("No FarmingPlots in the system"));
        System.out.println("Average crop value is " + average);
        return average;
    }

    private void createPlots() {
        createFarmingPlots();
        createLancingPlots();
        createLivingPlots();
        createMiningPlots();
        createWaterPlots();
    }

    private void createFarmingPlots() {
        Random random = new Random();
        for (Crop c : Crop.values()) {
            IntStream.range(1, random.nextInt(25)).forEach(i -> {
                int id = abstractPlots.size() + 1;
                FarmingPlot farm = new FarmingPlot(random.nextInt(1000), id, "Farm", borders
                        .get(random.nextInt(borders.size())), owners.get(random.nextInt(owners.size())),
                        true, c, random.nextInt(1000));
                abstractPlots.add(farm);
            });
        }
    }

    private void createWaterPlots() {
        abstractPlots.add(new WaterPlot(13255, abstractPlots.size() + 1, "WaterPlotA", borders.get(1), owners
                .get(0), true, 131200));
        abstractPlots.add(new WaterPlot(32255, abstractPlots.size() + 1, "WaterPlotB", borders.get(0), owners
                .get(1), true, 131200));
        abstractPlots.add(new WaterPlot(32355, abstractPlots.size() + 1, "WaterPlotC", borders.get(1), owners
                .get(2), true, 131200));
        abstractPlots.add(new WaterPlot(32545, abstractPlots.size() + 1, "WaterPlotD", borders.get(2), owners
                .get(3), true, 131200));
        abstractPlots.add(new WaterPlot(32555, abstractPlots.size() + 1, "WaterPlotE", borders.get(3), owners
                .get(4), true, 131200));
    }

    private void createMiningPlots() {
        Random random = new Random();
        for (Mineral m : Mineral.values()) {
            IntStream.range(1, random.nextInt(25)).forEach(i -> {
                int id = abstractPlots.size() + 1;
                new MiningPlot(random.nextInt(1000), id, "Mining", borders
                        .get(random.nextInt(borders.size())), owners.get(random.nextInt(owners.size())),
                        true, m, 100);
            });
        }
        abstractPlots.add(new MiningPlot(325, 11, "MiningPlotA", borders.get(1),
                owners.get(2), true, Mineral.PALLADIUM, 100));
        abstractPlots.add(new MiningPlot(1325, 12, "MiningPlotB", borders.get(3),
                owners.get(3), true, Mineral.GOLD, 32100));
        abstractPlots.add(new MiningPlot(3325, 13, "MiningPlotC", borders.get(2),
                owners.get(4), true, Mineral.PLATINUM, 103120));
        abstractPlots.add(new MiningPlot(3255, 14, "MiningPlotD", borders.get(1),
                owners.get(0), true, Mineral.REGOLITH, 131200));
    }

    private void createLivingPlots() {
        abstractPlots.add(new LivingPlot(325, abstractPlots.size() + 1, "LivingPlotA", borders.get(1),
                owners.get(1), true, 50));
        abstractPlots.add(new LivingPlot(225, abstractPlots.size() + 1, "LivingPlotB", borders.get(3),
                owners.get(4), true, 500));
        abstractPlots.add(new LivingPlot(115, abstractPlots.size() + 1, "LivingPlotC", borders.get(0),
                owners.get(4), true, 100));
    }

    private void createLancingPlots() {
        abstractPlots.add(new LancingPlot(3435, abstractPlots.size() + 1, "LocationLancingPlotA", borders.get(1),
                owners.get(1), true, 100));
        abstractPlots.add(new LancingPlot(4225, abstractPlots.size() + 1, "LocationLancingPlotB", borders.get(0),
                owners.get(1), true, 50));
        abstractPlots.add(new LancingPlot(6565, abstractPlots.size() + 1, "LocationLancingPlotC", borders.get(3),
                owners.get(4), true, 500));
        abstractPlots.add(new LancingPlot(875, abstractPlots.size() + 1, "LocationLancingPlotD", borders.get(1),
                owners.get(1), true, 100));
    }

    private void createBorders() {
        borders.add(new Border(Arrays.asList(1L, 2L, 3L, 4L, 5L)));
        borders.add(new Border(Arrays.asList(1111L, 2222L, 3L, 4L, 5L)));
        borders.add(new Border(Arrays.asList(1111111L, 22L, 3L, 4L, 5L)));
        borders.add(new Border(Arrays.asList(111111111L, 2222L, 3L, 4L, 5L)));
        borders.add(new Border(Arrays.asList(111111L, 22222L, 3L, 4L, 5L)));
    }

    private void createOwners() {
        owners.add(new Owner("China"));
        owners.add(new Owner("USA"));
        owners.add(new Owner("Russia"));
        owners.add(new Owner("Netherlands"));
        owners.add(new Owner("Vatican city"));
    }

    private void createTransfers(AbstractPlot ap) {
        int upperLimit = new Random().nextInt(20);
        LocalDate now = LocalDate.now();
        IntStream.range(0, upperLimit).forEach(i -> {
            Transfer transfer = Transfer.builder()
                    .plot(ap)
                    .oldOwner(owners.get(i % owners.size()))
                    .newOwner(owners.get((i + 1) % owners.size()))
                    .date(now.minusDays(i))
                    .build();
            transfers.add(transfer);
        });
    }
}
