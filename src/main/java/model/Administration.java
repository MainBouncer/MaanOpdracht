package model;

import enums.Crop;
import enums.Mineral;
import lombok.Getter;
import model.plots.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Getter
public class Administration {

    private List<AbstractPlot> abstractPlots = new ArrayList<>();
    private List<Owner> owners = new ArrayList<>();
    private List<Border> borders = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();

    public Administration() {
        createOwners();
        createBorders();
        createPlots();
        abstractPlots.forEach(this::createTransfers);
    }

    private void createPlots() {
        abstractPlots
                .add(new FarmingPlot(125, 1, "LocationFarmA", borders.get(1), owners.get(1), true, Crop.CUCUMBER, 50));
        abstractPlots
                .add(new FarmingPlot(3125, 2, "LocationFarmB", borders.get(3), owners.get(4), true, Crop.LETTUCE, 500));
        abstractPlots
                .add(new FarmingPlot(3435, 3, "LocationFarmC", borders.get(0), owners.get(4), true, Crop.RADISH, 100));

        abstractPlots.add(new LancingPlot(3435, 4, "LocationLancingPlotA", borders.get(1), owners.get(1), true, 100));
        abstractPlots.add(new LancingPlot(4225, 5, "LocationLancingPlotB", borders.get(0), owners.get(1), true, 50));
        abstractPlots.add(new LancingPlot(6565, 6, "LocationLancingPlotC", borders.get(3), owners.get(4), true, 500));
        abstractPlots.add(new LancingPlot(875, 7, "LocationLancingPlotD", borders.get(1), owners.get(1), true, 100));

        abstractPlots.add(new LivingPlot(325, 8, "LivingPlotA", borders.get(1), owners.get(1), true, 50));
        abstractPlots.add(new LivingPlot(225, 9, "LivingPlotB", borders.get(3), owners.get(4), true, 500));
        abstractPlots.add(new LivingPlot(115, 10, "LivingPlotC", borders.get(0), owners.get(4), true, 100));

        abstractPlots.add(new MiningPlot(325, 11, "MiningPlotA", borders.get(1), owners
                .get(2), true, Mineral.PALLADIUM, 100));
        abstractPlots
                .add(new MiningPlot(1325, 12, "MiningPlotB", borders.get(3), owners.get(3), true, Mineral.GOLD, 32100));
        abstractPlots.add(new MiningPlot(3325, 13, "MiningPlotC", borders.get(2), owners
                .get(4), true, Mineral.PLATINUM, 103120));
        abstractPlots.add(new MiningPlot(3255, 14, "MiningPlotD", borders.get(1), owners
                .get(0), true, Mineral.REGOLITH, 131200));

        abstractPlots.add(new WaterPlot(13255, 14, "WaterPlotA", borders.get(1), owners.get(0), true, 131200));
        abstractPlots.add(new WaterPlot(32255, 15, "WaterPlotB", borders.get(0), owners.get(1), true, 131200));
        abstractPlots.add(new WaterPlot(32355, 16, "WaterPlotC", borders.get(1), owners.get(2), true, 131200));
        abstractPlots.add(new WaterPlot(32545, 17, "WaterPlotD", borders.get(2), owners.get(3), true, 131200));
        abstractPlots.add(new WaterPlot(32555, 18, "WaterPlotE", borders.get(3), owners.get(4), true, 131200));
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
        ZonedDateTime now = ZonedDateTime.now();
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
