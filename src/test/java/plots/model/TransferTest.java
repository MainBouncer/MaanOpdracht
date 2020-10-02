package plots.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import plots.model.exception.IncorrectTransferException;

class TransferTest {

    @Test
    void shouldThrowIncorrectTransferExceptionIfSameOwnerTwice() {
        // given
        Owner owner = Owner.builder().name("test owner").build();

        // when + then
        assertThrows(IncorrectTransferException.class, () ->
                Transfer.builder().newOwner(owner).oldOwner(owner).build());
    }

    @Test
    void shouldThrowIncorrectTransferExceptionIfOwnerIsNull() {
        // given
        Owner owner = Owner.builder().name("test owner").build();

        // when + then
        assertThrows(IncorrectTransferException.class, () ->
                Transfer.builder().newOwner(null).oldOwner(owner).build());
        assertThrows(IncorrectTransferException.class, () ->
                Transfer.builder().newOwner(owner).oldOwner(null).build());
    }

    @Test
    void shouldNotThrowIncorrectTransferExceptionIfNotSameOwnerTwice() throws IncorrectTransferException {
        // given
        Owner one = Owner.builder().name("test owner").build();
        Owner two = Owner.builder().name("test owner").build();

        // when + then
        Transfer.builder().newOwner(one).oldOwner(two).build();
    }

}