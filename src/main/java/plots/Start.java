package plots;

import plots.administration.Administration;
import plots.enums.Crop;
import plots.model.plots.AbstractPlot;
import plots.model.plots.FarmingPlot;
import plots.model.plots.LivingPlot;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Start {

    public static void main(String[] args) {
        Administration administration = Administration.getInstance();

        List<AbstractPlot> plotsSoldOverAverage = administration.getPlotsSoldOverAverage();
        System.out.println("There are " + plotsSoldOverAverage.size() + " plots sold over average.");

        List<AbstractPlot> plotsSoldUnderAverage = administration.getPlotsSoldUnderAverage();
        System.out.println("There are " + plotsSoldUnderAverage.size() + " plots sold under average.");

        List<FarmingPlot> farmingPlotsWithGoodProduction = administration.getFarmingPlotsWithGoodProduction();
        System.out.println("There are " + farmingPlotsWithGoodProduction.size() + " with production over average.");

        long plotsSoldPerPeriod = administration.getPlotsSoldPerPeriod(LocalDate.now().minusDays(3), LocalDate.now());
        System.out.println("There are " + plotsSoldPerPeriod + " plots sold in this period.");

        int amountFarmingPlots = administration.getAmountOfPlotsOfType(FarmingPlot.class);
        System.out.println("There are " + amountFarmingPlots + " farming plots.");

        Map<Crop, Double> averageCropValue = administration.getAverageCropsValue();
        System.out.println("The average crop value is " + averageCropValue);

        Map<LivingPlot, Integer> peopleOver30PerPlot = administration.getNumberOfPeopleOver30PerPlot();
        System.out.println("People over 30 per plot are " + peopleOver30PerPlot);
    }

}
