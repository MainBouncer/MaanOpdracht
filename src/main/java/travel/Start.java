package travel;

import travel.administration.Administration;

public class Start {

//    Gewassen en delfstoffen
//
//    In de percelen die gebruikt worden voor tuinbouw worden gewassen geteeld:
//        Tomaat
//        Komkommer
//        Radijs
//        Sla
//        Paprika
//        Cannabis
//        Maanzaad
//    Elk perceel heeft een bepaalde oppervlakte en een bepaalde opbrengst in kg per vierkante meter per jaar.
//    Maak percelen aan met verschillende gewassen en verschillende opbrengsten.
//    Omdat Cannabis en Maanzaad onder de opiaten vallen is voor beide een vergunning nodig.
//    Een vergunning is een document/klasse waarin staat:
//        Wie de vergunning verleend heeft
//        Welk gewas
//        Voor welke periode
//    De opiaatvergunning is een Optional voor de klasse perceel.
//    Het moet mogelijk zijn om op te vragen welke gewassen de meeste opbrengst leveren, welke precelen de meeste opbrengst leveren. Ook moet aan de gewassen een voedingswaarde gekoppeld worden en bekeken kunnen worden welke gewassen de hoogste voedingswaarde opleveren.
//    Ook voor delfstoffen hebben hoog radioactieve stoffen een vergunning nodig.
//
//    Er moeten rapporten uitgedraaid worden over welke vergunning er verstrekt zijn. Dit moet voor zowel delfstoffen als gewassen werken.

    public static void main(String[] args) {
        Administration administration = new Administration();
        System.out.println("Travel companies size: " + administration.getTravelCompanies().size());
    }

}
