package resources;

public class PrintStatements_mo extends PrintStatements {
    @Override
    protected Object[][] getContents() {
        return new String[][]{
                {PLOT_OVER_AVERAGE, "suvwI' %d je"},
                {PLOT_UNDER_AVERAGE, "wamwI'ghomDaq loS wamwI'pu' lutu'lu' %d."},
                {FARMING_PLOT_OVER_AVERAGE, "Dujvo' ngemHom lutu'lu' %d lutu'lu'."},
                {PLOTS_SOLD_PER_PERIOD, "There are %d plots sold in this period."},
                {AMOUNT_OF_FARMING_PLOTS, "There are %d farming plots."},
                {AVERAGE_CROP_VALUE, "The average crop value for %s is %f"},
                {AMOUNT_OF_PEOPLE_OVER_30, "There are %d people with an age over 30 on plot %s"}
        };
    }
}
