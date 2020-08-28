package plots.administration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import plots.model.Owner;
import plots.model.Transfer;
import plots.model.plots.WaterPlot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DataCreatorTest {

    @Test
    void createTransfers_shouldNotCreateIfNotSellable() {
        // given
        WaterPlot plot = WaterPlot.builder().sellable(false).build();
        List<Owner> owners = new ArrayList<>();

        // when
        List<Transfer> resultList = DataCreator.createTransfers(plot, owners);

        // then
        assertThat(resultList).isEmpty();
    }

    @Test
    void createTransfers_shouldCreateIfSellable() {
        // given
        WaterPlot plot = WaterPlot.builder().sellable(true).build();
        Owner owner = Owner.builder().name("owner 1").build();
        List<Owner> owners = Collections.singletonList(owner);

        // when
        List<Transfer> resultList = DataCreator.createTransfers(plot, owners);

        // then
        assertThat(resultList).isNotEmpty();
        Transfer result = resultList.get(0);
        assertThat(result.getPlot()).isEqualTo(plot);
        assertThat(result.getNewOwner()).isEqualTo(owner);
        assertThat(result.getOldOwner()).isEqualTo(owner);
    }

}