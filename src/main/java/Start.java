import model.Administration;
import model.plots.AbstractPlot;

import java.util.List;

public class Start {

    public static void main(String[] args) {
        Administration administration = new Administration();

        List<AbstractPlot> plotsSoldOverAverage = administration.getPlotsSoldOverAverage();
        System.out.println("There are " + plotsSoldOverAverage.size() + " plots sold over average.");

        List<AbstractPlot> plotsSoldUnderAverage = administration.getPlotsSoldUnderAverage();
        System.out.println("There are " + plotsSoldUnderAverage.size() + " plots sold under average.");
    }

}
