package plots.administration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import plots.enums.Crop;
import plots.model.Border;
import plots.model.Mineral;
import plots.model.Owner;
import plots.model.Transfer;
import plots.model.plots.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataCreator {

    public static List<Mineral> createMinerals() {
        return Arrays.asList(
                plots.model.Mineral.builder().name("Helium-3").density(3).isRadioActive(true).number(65).build(),
                plots.model.Mineral.builder().name("Helium-3").density(23).isRadioActive(false).number(45).build(),
                plots.model.Mineral.builder().name("Iridium").density(3).isRadioActive(true).number(26).build(),
                plots.model.Mineral.builder().name("Regolith").density(12).isRadioActive(true).number(3).build(),
                plots.model.Mineral.builder().name("Gold").density(34).isRadioActive(true).number(1).build(),
                plots.model.Mineral.builder().name("Palladium").density(54).isRadioActive(false).number(23).build(),
                plots.model.Mineral.builder().name("Platinum").density(15).isRadioActive(true).number(45).build()
        );
    }

    public static List<Owner> createOwners() {
        return Arrays.asList(
                new Owner("China"),
                new Owner("USA"),
                new Owner("Russia"),
                new Owner("Netherlands"),
                new Owner("Vatican city")
        );
    }

    public static List<Border> createBorders() {
        return Arrays.asList(
                new Border(Arrays.asList(1L, 2L, 3L, 4L, 5L)),
                new Border(Arrays.asList(1111L, 2222L, 3L, 4L, 5L)),
                new Border(Arrays.asList(1111111L, 22L, 3L, 4L, 5L)),
                new Border(Arrays.asList(111111111L, 2222L, 3L, 4L, 5L)),
                new Border(Arrays.asList(111111L, 22222L, 3L, 4L, 5L))
        );
    }

    public static List<AbstractPlot> createPlots(List<Border> borders, List<Owner> owners, List<Mineral> minerals) {
        List<AbstractPlot> abstractPlots = new ArrayList<>();
        createFarmingPlots(abstractPlots, borders, owners);
        createLancingPlots(abstractPlots, borders, owners);
        createLivingPlots(abstractPlots, borders, owners);
        createMiningPlots(abstractPlots, borders, owners, minerals);
        createWaterPlots(abstractPlots, borders, owners);
        return abstractPlots;
    }

    public static List<Transfer> createTransfers(AbstractPlot ap, List<Owner> owners) {
        if (!ap.isSellable()) {
            return Collections.emptyList();
        }

        List<Transfer> transfers = new ArrayList<>();
        int upperLimit = Math.max(new Random().nextInt(20), 1);
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
        return transfers;
    }

    private static void createFarmingPlots(List<AbstractPlot> abstractPlots, List<Border> borders, List<Owner> owners) {
        Random random = new Random();
        for (Crop c : Crop.values()) {
            int upperBound = Math.max(random.nextInt(25), 1);
            System.out.println("Creating " + upperBound + " " + c.getName() + " farms.");
            IntStream.range(0, upperBound).forEach(i -> {
                FarmingPlot farm = new FarmingPlot(2500, abstractPlots.size() + 1,
                        "Farm", getRandomBorder(borders), getRandomOwner(owners),
                        isSellable(), c, random.nextInt(1000));
                abstractPlots.add(farm);
            });
        }
    }

    private static void createWaterPlots(List<AbstractPlot> abstractPlots, List<Border> borders, List<Owner> owners) {
        abstractPlots.add(new WaterPlot(13255, abstractPlots.size() + 1, "WaterPlotA", getRandomBorder(borders),
                getRandomOwner(owners), isSellable(), 131200));
        abstractPlots.add(new WaterPlot(32255, abstractPlots.size() + 1, "WaterPlotB", getRandomBorder(borders),
                getRandomOwner(owners), isSellable(), 131200));
        abstractPlots.add(new WaterPlot(32355, abstractPlots.size() + 1, "WaterPlotC", getRandomBorder(borders),
                getRandomOwner(owners), isSellable(), 131200));
        abstractPlots.add(new WaterPlot(32545, abstractPlots.size() + 1, "WaterPlotD", getRandomBorder(borders),
                getRandomOwner(owners), isSellable(), 131200));
        abstractPlots.add(new WaterPlot(32555, abstractPlots.size() + 1, "WaterPlotE", getRandomBorder(borders),
                getRandomOwner(owners), isSellable(), 131200));
    }

    private static void createMiningPlots(List<AbstractPlot> abstractPlots, List<Border> borders, List<Owner> owners, List<Mineral> minerals) {
        Random random = new Random();
        for (Mineral m : minerals) {
            int upperBound = Math.max(random.nextInt(25), 1);
            IntStream.range(0, upperBound).forEach(i -> {
                int id = abstractPlots.size() + 1;
                new MiningPlot(random.nextInt(1000), id, "Mining", getRandomBorder(borders),
                        getRandomOwner(owners), isSellable(), m, 100);
            });
        }
    }

    private static void createLivingPlots(List<AbstractPlot> abstractPlots, List<Border> borders, List<Owner> owners) {
        abstractPlots.add(new LivingPlot(325, abstractPlots.size() + 1, "LivingPlotA", getRandomBorder(borders),
                getRandomOwner(owners), isSellable(), Arrays.asList(10, 20, 30, 40, 50, 60, 100)));
        abstractPlots.add(new LivingPlot(225, abstractPlots.size() + 1, "LivingPlotB", getRandomBorder(borders),
                getRandomOwner(owners), isSellable(), Arrays.asList(43, 44, 55, 60, 10)));
        abstractPlots.add(new LivingPlot(115, abstractPlots.size() + 1, "LivingPlotC", getRandomBorder(borders),
                getRandomOwner(owners), isSellable(), Arrays.asList(50, 1, 10, 60, 10, 20, 40, 50)));
    }

    private static void createLancingPlots(List<AbstractPlot> abstractPlots, List<Border> borders, List<Owner> owners) {
        abstractPlots.add(new LancingPlot(3435, abstractPlots.size() + 1, "LocationLancingPlotA",
                getRandomBorder(borders), getRandomOwner(owners), isSellable(), 100));
        abstractPlots.add(new LancingPlot(4225, abstractPlots.size() + 1, "LocationLancingPlotB",
                getRandomBorder(borders), getRandomOwner(owners), isSellable(), 50));
        abstractPlots.add(new LancingPlot(6565, abstractPlots.size() + 1, "LocationLancingPlotC",
                getRandomBorder(borders), getRandomOwner(owners), isSellable(), 500));
        abstractPlots.add(new LancingPlot(875, abstractPlots.size() + 1, "LocationLancingPlotD",
                getRandomBorder(borders), getRandomOwner(owners), isSellable(), 100));
    }

    private static Owner getRandomOwner(List<Owner> owners) {
        return owners.get(new Random().nextInt(owners.size()));
    }

    private static Border getRandomBorder(List<Border> borders) {
        return borders.get(new Random().nextInt(borders.size()));
    }

    private static boolean isSellable() {
        return new Random().nextBoolean();
    }

}