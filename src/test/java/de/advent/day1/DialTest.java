package de.advent.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DialTest {

    public static Stream<Arguments> rotateAndCountingZeroes_args() {
        return Stream.of(
                arguments("R150", 2),
                arguments("L150", 2)
        );
    }

    public static Stream<Arguments> rotateWithoutCountingZeroes_args() {
        return Stream.of(
                arguments("L5", 45),
                arguments("R5", 55),
                arguments("R55", 5)
        );

    }

    @Test
    void rotate_WithoutCountingZeroes_notStartingWithLOrR_throwsUnsupportedOperationException() {
        var dial = new Dial();

        assertThatThrownBy(() -> dial.rotateWithoutCountingZeroes("55")).isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("must be prefixed with L or R");
    }

    @ParameterizedTest
    @MethodSource("rotateWithoutCountingZeroes_args")
    void rotateWithoutCountingZeroes(String input, int expectedValue) {
        var dial = new Dial();

        dial.rotateWithoutCountingZeroes("L5");

        assertThat(dial.getCurrentValue()).isEqualTo(45);
    }

    @Test
    void rotateAndReturnNumberOfTimesPointedToZero_notStartingWithLOrR_throwsUnsupportedOperationException() {
        var dial = new Dial();

        assertThatThrownBy(() -> dial.rotateAndReturnNumberOfTimesPointedToZero("55")).isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("must be prefixed with L or R");
    }

    @ParameterizedTest
    @MethodSource("rotateAndCountingZeroes_args")
    void rotateAndReturnNumberOfTimesPointedToZero_returnsNumberOfZeroes(String input, int expectedValue) {
        var dial = new Dial();

        var numberOfTimesPointedToZero = dial.rotateAndReturnNumberOfTimesPointedToZero(input);

        assertThat(numberOfTimesPointedToZero).isEqualTo(expectedValue);
    }

    @Test
    void firstPart_solution() throws IOException {
        var dial = new Dial();
        var lines = Files.readAllLines(Paths.get("src/test/resources/day1/input-first-part.txt"));
        var zeroes = 0;

        for (var line : lines) {
            dial.rotateWithoutCountingZeroes(line);
            if (dial.getCurrentValue() == 0) {
                zeroes++;
            }
        }

        assertThat(zeroes).isEqualTo(1129);
    }

    @Test
    void secondPart_solution() throws IOException {
        var dial = new Dial();
        var lines = Files.readAllLines(Paths.get("src/test/resources/day1/input-first-part.txt"));
        var zeroes = 0;

        for (var line : lines) {
            zeroes += dial.rotateAndReturnNumberOfTimesPointedToZero(line);
        }

        assertThat(zeroes).isEqualTo(6638);
    }


}