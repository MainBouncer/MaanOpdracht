package resources;

public class PrintStatements_nl extends PrintStatements {
    @Override
    protected Object[][] getContents() {
        return new String[][]{
                {PLOT_OVER_AVERAGE, "Er zijn %d percelen meer dan gemiddeld verkocht."},
                {PLOT_UNDER_AVERAGE, "Er zijn %d percelen onder gemiddeld verkocht."},
                {FARMING_PLOT_OVER_AVERAGE, "Er zijn %d farming plots with production over average."},
                {PLOTS_SOLD_PER_PERIOD, "There are %d plots sold in this period."},
                {AMOUNT_OF_FARMING_PLOTS, "There are %d farming plots."},
                {AVERAGE_CROP_VALUE, "The average crop value for %s is %f"},
                {AMOUNT_OF_PEOPLE_OVER_30, "There are %d people with an age over 30 on plot %s"}
        };
    }
}
