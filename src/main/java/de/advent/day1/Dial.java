package de.advent.day1;


class Dial {

    private int currentValue = 50;

    void rotateWithoutCountingZeroes(String input) {
        var rotationDirection = input.substring(0, 1);
        validate(rotationDirection);
        var valueToRotate = Integer.parseInt(input.substring(1));
        if (rotationDirection.equals("L")) {
            rotateLeft(valueToRotate);
        } else if (rotationDirection.equals("R")) {
            rotateRight(valueToRotate);
        }
    }

    int rotateAndReturnNumberOfTimesPointedToZero(String input) {
        var numberOfTimesZeroPassed = 0;
        var rotationDirection = input.substring(0, 1);
        validate(rotationDirection);
        var valueToRotate = Integer.parseInt(input.substring(1));
        for (int i = 0; i < valueToRotate; i++) {
            if (rotationDirection.equals("L")) {
                rotateSingleLeft();
            } else if (rotationDirection.equals("R")) {
                rotateSingleRight();
            }
            if (getCurrentValue() == 0) {
                numberOfTimesZeroPassed++;
            }
        }
        return numberOfTimesZeroPassed;
    }

    private void rotateLeft(int value) {
        currentValue -= value;
    }

    private void rotateRight(int value) {
        currentValue += value;
    }

    private void rotateSingleRight() {
        rotateRight(1);
    }

    private void rotateSingleLeft() {
        rotateLeft(1);
    }

    int getCurrentValue() {
        return currentValue % 100;
    }

    private void validate(String rotationDirection) {
        if (!rotationDirection.equals("L") && !rotationDirection.equals("R")) {
            throw new UnsupportedOperationException("must be prefixed with L or R");
        }
    }
}
