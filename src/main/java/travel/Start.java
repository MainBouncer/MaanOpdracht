package travel;

import travel.administration.Administration;

public class Start {

    public static void main(String[] args) {
        Administration administration = new Administration();
        System.out.println("Travel companies size: " + administration.getTravelCompanies().size());
    }
    
}
