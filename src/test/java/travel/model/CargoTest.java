package travel.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import travel.enums.CargoType;

class CargoTest {

    @Test
    void compareTo_shouldIgnoreType() {
        // given
        Cargo gas = Cargo.builder().cargoType(CargoType.GAS).build();
        Cargo liquid = Cargo.builder().cargoType(CargoType.LIQUID).build();

        // when + then
        testCompareTo(gas, liquid, 0, 0);
    }

    @Test
    void compareTo_shouldChoosePerishable() {
        // given
        Cargo perishable = Cargo.builder().perishable(true).build();
        Cargo safe = Cargo.builder().perishable(false).build();

        // when + then
        testCompareTo(perishable, safe, 1, -1);
    }

    @Test
    void compareTo_shouldUseRegularIfBothPerishable() {
        // given
        Cargo bigger = Cargo.builder().perishable(true).volume(100).build();
        Cargo smaller = Cargo.builder().perishable(true).volume(10).build();

        // when + then
        testCompareTo(bigger, smaller, -1, 1);
    }

    @Test
    void compareTo_shouldCheckVolumeBeforeWeight() {
        // given
        Cargo bigger = Cargo.builder().volume(100).weight(10).build();
        Cargo smaller = Cargo.builder().volume(10).weight(100).build();

        // when + then
        testCompareTo(bigger, smaller, -1, 1);
    }

    @Test
    void compareTo_shouldCheckWeight() {
        // given
        Cargo heavier = Cargo.builder().weight(100).build();
        Cargo lighter = Cargo.builder().weight(10).build();

        // when + then
        testCompareTo(heavier, lighter, -1, 1);
    }

    private void testCompareTo(Cargo one, Cargo two, int expectedOne, int expectedTwo) {
        // when
        int resultOne = one.compareTo(two);
        int resultTwo = two.compareTo(one);

        // then
        assertThat(resultOne).isEqualTo(expectedOne);
        assertThat(resultTwo).isEqualTo(expectedTwo);
    }

}