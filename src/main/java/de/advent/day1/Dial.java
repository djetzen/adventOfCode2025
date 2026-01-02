package de.advent.day1;

class Dial {

    private int currentValue = 50;

    void rotateWithoutCountingZeroes(String input) {
        var rotationDirection = input.substring(0, 1);
        if (rotationDirection.equals("L")) {
            rotateLeft(Integer.parseInt(input.substring(1)));
        } else if (rotationDirection.equals("R")) {
            rotateRight(Integer.parseInt(input.substring(1)));
        } else {
            throw new UnsupportedOperationException("must be prefixed with L or R");
        }
    }

    int rotateAndReturnNumberOfTimesPointedToZero(String input) {
        var numberOfTimesZeroPassed = 0;
        var rotationDirection = input.substring(0, 1);
        if (rotationDirection.equals("L")) {
            var valueToRotate = Integer.parseInt(input.substring(1));
            for (int i = 0; i < valueToRotate; i++) {
                rotateLeft(1);
                if (getCurrentValue() == 0) {
                    numberOfTimesZeroPassed++;
                }
            }
        } else if (rotationDirection.equals("R")) {
            var valueToRotate = Integer.parseInt(input.substring(1));
            for (int i = 0; i < valueToRotate; i++) {
                rotateRight(1);
                if (getCurrentValue() == 0) {
                    numberOfTimesZeroPassed++;
                }
            }
        } else {
            throw new UnsupportedOperationException("must be prefixed with L or R");
        }
        return numberOfTimesZeroPassed;
    }

    private void rotateLeft(int value) {
        currentValue -= value;
    }

    private void rotateRight(int value) {
        currentValue += value;
    }

    int getCurrentValue() {
        return currentValue % 100;
    }
}
