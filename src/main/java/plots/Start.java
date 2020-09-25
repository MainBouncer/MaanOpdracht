package plots;

import plots.administration.Administration;
import plots.enums.Crop;
import plots.model.plots.AbstractPlot;
import plots.model.plots.FarmingPlot;
import plots.model.plots.LivingPlot;
import resources.PrintStatements;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Start {

    public static void main(String[] args) {
        Administration administration = Administration.getInstance();

        ResourceBundle resourceBundle = ResourceBundle.getBundle(PrintStatements.class.getName(), new Locale("nl"));

        List<AbstractPlot> plotsSoldOverAverage = administration.getPlotsSoldOverAverage();
        System.out.println(String.format(resourceBundle.getString(PrintStatements.PLOT_OVER_AVERAGE), plotsSoldOverAverage.size()));

        List<AbstractPlot> plotsSoldUnderAverage = administration.getPlotsSoldUnderAverage();
        System.out.println(String.format(resourceBundle.getString(PrintStatements.PLOT_UNDER_AVERAGE), plotsSoldUnderAverage.size()));

        List<FarmingPlot> farmingPlotsWithGoodProduction = administration.getFarmingPlotsWithGoodProduction();
        System.out.println(String.format(resourceBundle.getString(PrintStatements.FARMING_PLOT_OVER_AVERAGE), farmingPlotsWithGoodProduction.size()));

        long plotsSoldPerPeriod = administration.getPlotsSoldPerPeriod(LocalDate.now().minusDays(3), LocalDate.now());
        System.out.println(String.format(resourceBundle.getString(PrintStatements.PLOTS_SOLD_PER_PERIOD), plotsSoldPerPeriod));

        int amountFarmingPlots = administration.getAmountOfPlotsOfType(FarmingPlot.class);
        System.out.println(String.format(resourceBundle.getString(PrintStatements.AMOUNT_OF_FARMING_PLOTS), amountFarmingPlots));

        Map<Crop, Double> averageCropValue = administration.getAverageCropsValue();

        averageCropValue.forEach((crop, value) ->
                System.out.println(String.format(resourceBundle.getString(PrintStatements.AVERAGE_CROP_VALUE), crop.getName(), value))
        );

        Map<LivingPlot, Integer> peopleOver30PerPlot = administration.getNumberOfPeopleOver30PerPlot();

        peopleOver30PerPlot.forEach((livingPlot, value) ->
                System.out.println(String.format(resourceBundle.getString(PrintStatements.AMOUNT_OF_PEOPLE_OVER_30), value, livingPlot.toString()))
        );

        administration.getBestFarmingPlot();
    }

}
