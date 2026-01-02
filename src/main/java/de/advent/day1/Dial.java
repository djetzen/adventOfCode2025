package de.advent.day1;

class Dial {

    private int currentValue = 50;

    void rotate(String input) {
        var rotationDirection = input.substring(0, 1);
        if (rotationDirection.equals("L")) {
            rotateLeft(Integer.parseInt(input.substring(1)));
        } else if (rotationDirection.equals("R")) {
            rotateRight(Integer.parseInt(input.substring(1)));
        } else {
            throw new UnsupportedOperationException("must be prefixed with L or R");
        }
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
