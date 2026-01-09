package de.advent.day2;

import java.util.List;
import java.util.stream.LongStream;

public class NumberFinder {

    List<Long> numbersInRange(String firstValue, String secondValue) {
        if (firstValue.startsWith("0") || secondValue.startsWith("0")) {
            throw new IllegalArgumentException("number must not start with 0");
        }
        var firstNumber = Long.parseLong(firstValue);
        var secondNumber = Long.parseLong(secondValue);
        if (firstNumber > secondNumber) {
            throw new IllegalArgumentException("second number needs to be smaller");
        }
        return LongStream.range(firstNumber, secondNumber + 1).boxed().toList();
    }
}
