import plots.administration.Administration;
import plots.enums.Crop;
import plots.model.plots.AbstractPlot;
import plots.model.plots.FarmingPlot;
import plots.model.plots.LivingPlot;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Start {

//    Deel 4
//    Om mensen en waren van de ene plek naar de andere te kunnen vervoeren zijn er op de maan een aantal vervoersbedrijven.
//    Deze vervoersbedrijven maken gebruik van verschillende vervoersmiddelen, zoals een raket of een monorail.
//    De vervoersbedrijven hebben voor het verplaatsen van passagier een set van beschikbare zitplaatsen per trein, per vertrektijd, per station.
//    Een passagier kan een plek reserveren, deze plek is dan niet meer beschikbaar.  De passagier kan een specifieke plek reserveren.
//    Voor het verplaatsen van vracht worden vrachtlijsten bijgehouden dit zijn queues.
//    Op de vrachtlijsten staan vrachten (vrachtklasse, met gewicht, inhoud, bederfelijk J/N)
//    Voor de velden inhoud en gewicht zou gewerkt kunnen worden met een mengsel van long, Long, int en Integer.
//    Met autoboxing zou de compiler dan zelf moeten bepalen welke methode gebruikt wordt of welke Wrapperclass/primitive er gebruikt wordt.
//    Er zijn kratten aanwezig voor bepaald type (delf)stoffen.
//    Er kunnen verschillende types kratten gedefinieerd worden, verschillende groottes of voor verschillende soorten stoffen: vloeibaar, gas, vast.
//    De vrachtlijst kan verschillende soorten kratten bevatten.
//    Er zijn kratten en er zijn passagiers, ze nemen allebei een bepaalde ruimte in.
//            Per rit (van A naar B) wordt gekeken hoe de vracht en de passagiers zo optimaal mogelijk vervoerd kunnen worden.
//            Zo moet er rekening gehouden worden met wat er het eerst of het laatst in- of uitgepakt moet worden, denk bijvoorbeeld aan bederfelijk waar.
//            Bij de sortering komen dan deze kratten bovenaan de lijst.
//    De beschikbare ruimte moet zo veel mogelijk worden gevuld.
//    Je zou bijvoorbeeld een monorail kunnen hebben waarin tien kratten passen. Iedereen die iets vervoerd wil hebben zet het in de queue.
//    Als de queue vol is kan de monorail vertrekken. Je kunt er dan voor kiezen om kratten met bederfelijke waar voorrang te geven in de queue.
//    De verschillende typen kratten moeten onderling vergeleken kunnen worden en gesorteerd kunnen worden op bepaalde eigenschappen.


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
