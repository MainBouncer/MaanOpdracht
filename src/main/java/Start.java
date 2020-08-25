import model.Administration;
import model.plots.AbstractPlot;
import model.plots.FarmingPlot;

import java.util.List;

public class Start {

    public static void main(String[] args) {
        Administration administration = new Administration();

        List<AbstractPlot> plotsSoldOverAverage = administration.getPlotsSoldOverAverage();
        System.out.println("There are " + plotsSoldOverAverage.size() + " plots sold over average.");

        List<AbstractPlot> plotsSoldUnderAverage = administration.getPlotsSoldUnderAverage();
        System.out.println("There are " + plotsSoldUnderAverage.size() + " plots sold under average.");

        List<FarmingPlot> farmingPlotsWithGoodProduction = administration.getFarmingPlotsWithGoodProduction();
        System.out.println("There are " + farmingPlotsWithGoodProduction.size() + " with production over average.");
    }

}
