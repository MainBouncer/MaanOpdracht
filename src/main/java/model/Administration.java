package model;

import enums.Crop;
import enums.Mineral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Administration {

    List<AbstractPlot> abstractPlots = new ArrayList<>();
    List<Owner> owners = new ArrayList<>();
    List<Border> borders = new ArrayList<>();

    public List<AbstractPlot> getPlots() {
        return abstractPlots;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public List<Border> getBorders() {
        return borders;
    }

    public Administration() {
        createData();
    }

    private void createData() {
        owners.add(new Owner("China"));
        owners.add(new Owner("USA"));
        owners.add(new Owner("Russia"));
        owners.add(new Owner("Netherlands"));
        owners.add(new Owner("Vatican city"));

        borders.add(new Border(Arrays.asList(1L, 2L, 3L, 4L, 5L)));
        borders.add(new Border(Arrays.asList(1111L, 2222L, 3L, 4L, 5L)));
        borders.add(new Border(Arrays.asList(1111111L, 22L, 3L, 4L, 5L)));
        borders.add(new Border(Arrays.asList(111111111L, 2222L, 3L, 4L, 5L)));
        borders.add(new Border(Arrays.asList(111111L, 22222L, 3L, 4L, 5L)));

        abstractPlots.add(new FarmingPlot(125, 1, "LocationFarmA", borders.get(1), owners.get(1), true, Crop.CUCUMBER, 50));
        abstractPlots.add(new FarmingPlot(3125, 2, "LocationFarmB", borders.get(3), owners.get(4), true, Crop.LETTUCE, 500));
        abstractPlots.add(new FarmingPlot(3435, 3, "LocationFarmC", borders.get(0), owners.get(4), true, Crop.RADISH, 100));

        abstractPlots.add(new LancingPlot(3435, 4, "LocationLancingPlotA", borders.get(1), owners.get(1), true, 100));
        abstractPlots.add(new LancingPlot(4225, 5, "LocationLancingPlotB", borders.get(0), owners.get(1), true, 50));
        abstractPlots.add(new LancingPlot(6565, 6, "LocationLancingPlotC", borders.get(3), owners.get(4), true, 500));
        abstractPlots.add(new LancingPlot(875, 7, "LocationLancingPlotD", borders.get(1), owners.get(1), true, 100));

        abstractPlots.add(new LivingPlot(325, 8, "LivingPlotA", borders.get(1), owners.get(1), true, 50));
        abstractPlots.add(new LivingPlot(225, 9, "LivingPlotB", borders.get(3), owners.get(4), true, 500));
        abstractPlots.add(new LivingPlot(115, 10, "LivingPlotC", borders.get(0), owners.get(4), true, 100));

        abstractPlots.add(new MiningPlot(325, 11, "MiningPlotA", borders.get(1), owners.get(2), true, Mineral.PALLADIUM, 100));
        abstractPlots.add(new MiningPlot(1325, 12, "MiningPlotB", borders.get(3), owners.get(3), true, Mineral.GOLD, 32100));
        abstractPlots.add(new MiningPlot(3325, 13, "MiningPlotC", borders.get(2), owners.get(4), true, Mineral.PLATINUM, 103120));
        abstractPlots.add(new MiningPlot(3255, 14, "MiningPlotD", borders.get(1), owners.get(0), true, Mineral.REGOLITH, 131200));

        abstractPlots.add(new WaterPlot(13255, 14, "WaterPlotA", borders.get(1), owners.get(0), true, 131200));
        abstractPlots.add(new WaterPlot(32255, 15, "WaterPlotB", borders.get(0), owners.get(1), true, 131200));
        abstractPlots.add(new WaterPlot(32355, 16, "WaterPlotC", borders.get(1), owners.get(2), true, 131200));
        abstractPlots.add(new WaterPlot(32545, 17, "WaterPlotD", borders.get(2), owners.get(3), true, 131200));
        abstractPlots.add(new WaterPlot(32555, 18, "WaterPlotE", borders.get(3), owners.get(4), true, 131200));


    }

}
