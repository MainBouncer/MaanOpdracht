package travel.administration;

import lombok.Getter;
import travel.model.TravelCompany;

import java.util.List;

@Getter
public class Administration {

    private List<TravelCompany> travelCompanies;

    public Administration() {
        travelCompanies = DataCreator.createCompanies();
    }

}
