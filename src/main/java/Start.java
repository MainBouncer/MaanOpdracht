import model.Administration;
import model.plots.AbstractPlot;
import model.plots.FarmingPlot;

import java.time.LocalDate;
import java.util.List;

public class Start {
//
    // Deel 2
//    Ook moet er een methode zijn om het aantal verkochte maanpercelen te berekenen per periode uit te rekenen.
//    Een methode om het aantal delfstof percelen en het aantal gewas percelen te berekenen.
//    TODO: De gemiddelde opbrengst van een perceel per gewas en per delfstof moet berekend kunnen worden.
//    TODO: Het aantal inwoners ouder dan 30 jaar per woonperceel moet opgevraagd worden.
//
//
//    TODO: Dit alles moet periodiek gerapporteerd worden. Deze periode moet flexibel zijn.
//    Om te laten zien dat het werkt graag de rapportage uitdraaien per maand (mag console applicatie zijn met output van de rapoortage in het console).

    // Deel 3
//    TODO: De VN wil de administratie van delfstoffen verder uitwerken. De enum delfstof wordt vervangen door een immutable object.
//    TODO: Dit Object bevat gegevens over bijv. elementnaam, elementnummer, stofdichtheid, radioactief. Voor het maken van deze objecten hebben we een klasse DelfstofBuilder nodig.
//
//    Maanadministratie moet singleton worden.
//
//    Verder, voor zover dit nog niet is toegepast op het model dient encapsulation te worden toegepast.


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
    }

}
