package de.advent.day2;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class InvalidIdFinderTest {

    InvalidIdFinder invalidIdFinder = new InvalidIdFinder();

    @Nested
    class SimpleChecks {

        @Test
        void idWithNoDuplicates_isNotInvalid() {
            var isInvalid = invalidIdFinder.isIdInvalidSimpleCheck(123456789L);

            assertThat(isInvalid).isFalse();
        }

        @Test
        void idWithSingleDuplicate_isInvalid() {
            var isInvalid = invalidIdFinder.isIdInvalidSimpleCheck(11L);

            assertThat(isInvalid).isTrue();
        }

        @Test
        void idWithSingleDuplicateInBody_isNotInvalid() {
            var isInvalid = invalidIdFinder.isIdInvalidSimpleCheck(2112L);

            assertThat(isInvalid).isFalse();
        }

        @Test
        void idWithDoubleNumbersButNoDuplicate_isValid() {
            var isInvalid = invalidIdFinder.isIdInvalidSimpleCheck(1234321L);

            assertThat(isInvalid).isFalse();
        }

        @Test
        void complexDuplicateInMiddle_isValid() {
            var isInvalid = invalidIdFinder.isIdInvalidSimpleCheck(123456456321L);

            assertThat(isInvalid).isFalse();
        }

        @Test
        void complexDuplicate_isInvalid() {
            var isInvalid = invalidIdFinder.isIdInvalidSimpleCheck(1234512345L);

            assertThat(isInvalid).isTrue();
        }

        @Test
        void numbers_withNotEvenDigitsAreValid() {
            var isInvalid = invalidIdFinder.isIdInvalidSimpleCheck(101L);

            assertThat(isInvalid).isFalse();
        }

        @Test
        void firstPart_solution() throws IOException {
            var invalidSum = 0L;
            var numberFinder = new NumberFinder();
            var invalidIdFinder = new InvalidIdFinder();
            var idRanges = Files.readString(Paths.get("src/test/resources/day2/input-first-part.txt")).split(",");
            for (var idRange : idRanges) {
                var range = idRange.split("-");
                var ids = numberFinder.numbersInRange(range[0].trim(), range[1].trim());
                for (var id : ids) {
                    if (invalidIdFinder.isIdInvalidSimpleCheck(id)) {
                        invalidSum += id;
                    }
                }
            }
            assertThat(invalidSum).isEqualTo(21139440284L);
        }
    }

}