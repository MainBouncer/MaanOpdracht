package plots.administration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import plots.model.Owner;
import plots.model.Transfer;
import plots.model.exception.UnexpectedValueException;
import plots.model.plots.WaterPlot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DataCreatorTest {

    @Test
    void createTransfers_shouldNotCreateIfNotSellable() throws UnexpectedValueException {
        // given
        WaterPlot plot = WaterPlot.builder().size(1).sellable(false).build();
        List<Owner> owners = new ArrayList<>();

        // when
        List<Transfer> resultList = DataCreator.createTransfers(plot, owners);

        // then
        assertThat(resultList).isEmpty();
    }

    @Test
    void createTransfers_shouldCreateIfSellable() throws UnexpectedValueException {
        // given
        WaterPlot plot = WaterPlot.builder().size(1).sellable(true).build();
        Owner owner1 = Owner.builder().name("owner 1").build();
        Owner owner2 = Owner.builder().name("owner 2").build();
        List<Owner> owners = Arrays.asList(owner1, owner2);

        // when
        List<Transfer> resultList = DataCreator.createTransfers(plot, owners);

        // then
        assertThat(resultList).isNotEmpty();
        Transfer result = resultList.get(0);
        assertThat(result.getPlot()).isEqualTo(plot);
        assertThat(result.getNewOwner()).isNotNull();
        assertThat(result.getOldOwner()).isNotNull();
    }

}