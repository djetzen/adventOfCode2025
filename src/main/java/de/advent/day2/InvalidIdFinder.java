package de.advent.day2;

import java.util.HashSet;

public class InvalidIdFinder {

    boolean isIdInvalidSimpleCheck(Long id) {
        if (id.toString().length() % 2 == 1) {
            return false;
        }
        var firstChunk = Long.parseLong(id.toString().substring(0, id.toString().length() / 2));
        var secondChunk = Long.parseLong(id.toString().substring(id.toString().length() / 2));
        return firstChunk == secondChunk;
    }


    boolean isIdInvalidComplexCheck(Long id) {
        for (var i = id.toString().length() / 2; i > 0; i--) {
            if (id.toString().length() % i == 0) {
                var uniqueChunks = splitIntoEqualChunks(id, i);
                if (uniqueChunks.size() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private HashSet<Long> splitIntoEqualChunks(Long id, int numberOfChunks) {
        var chunks = new HashSet<Long>();
        for (int j = 0; j < id.toString().length() / numberOfChunks; j++) {
            chunks.add(Long.parseLong(id.toString().substring(numberOfChunks * j, numberOfChunks * j + numberOfChunks)));
        }
        return chunks;
    }
}
