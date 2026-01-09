package de.advent.day2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberFinderTest {
    NumberFinder numberFinder = new NumberFinder();

    @Test
    void firstNumberNeedsToBeSmallerThanSecondNumber() {
        assertThatThrownBy(() -> numberFinder.numbersInRange("2", "1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bothValuesNeedToBeNumbers() {
        assertThatThrownBy(() -> numberFinder.numbersInRange("A", "1")).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> numberFinder.numbersInRange("1", "B")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void getValuesBetweenNumbers() {
        var numbers = numberFinder.numbersInRange("1", "5");

        assertThat(numbers).containsExactlyInAnyOrder(1L, 2L, 3L, 4L, 5L);
    }

    @Test
    void leadingZeroIsNotAllowed() {
        assertThatThrownBy(() -> numberFinder.numbersInRange("01", "2")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> numberFinder.numbersInRange("1", "02")).isInstanceOf(IllegalArgumentException.class);
    }
}