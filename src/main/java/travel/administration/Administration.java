package travel.administration;

import lombok.Getter;
import travel.model.TravelCompany;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Administration {
    private List<TravelCompany> travelCompanies;

    public Administration() {
        travelCompanies = DataCreator.createCompanies();
    }

}
