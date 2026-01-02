package de.advent.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DialTest {

    @Test
    void rotate_notStartingWithLOrR_throwsUnsupportedOperationException() {
        var dial = new Dial();

        assertThatThrownBy(() -> dial.rotate("55")).isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("must be prefixed with L or R");
    }

    @Test
    void rotateLeftSubtractsValue() {
        var dial = new Dial();

        dial.rotate("L5");

        assertThat(dial.getCurrentValue()).isEqualTo(45);
    }

    @Test
    void rotateRightAddsValue() {
        var dial = new Dial();

        dial.rotate("R5");

        assertThat(dial.getCurrentValue()).isEqualTo(55);
    }

    @Test
    void rotate_usesModulo100() {
        var dial = new Dial();

        dial.rotate("R55");

        assertThat(dial.getCurrentValue()).isEqualTo(5);
    }

    @Test
    void rotateTestInput_and_countZeroes() throws IOException {
        var dial = new Dial();
        var lines = Files.readAllLines(Paths.get("src/test/resources/day1/input-first-part.txt"));
        var zeroes = 0;

        for (var line : lines) {
            dial.rotate(line);
            if (dial.getCurrentValue() == 0) {
                zeroes++;
            }
        }

        assertThat(zeroes).isEqualTo(1129);
    }
}