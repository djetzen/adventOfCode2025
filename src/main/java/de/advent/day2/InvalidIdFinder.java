package de.advent.day2;

import java.util.stream.IntStream;

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
            int finalI = i;
            var listOfChunks = IntStream.range(0, id.toString().length() / i)
                    .mapToObj(chunkIndex -> {
                        int start = chunkIndex * finalI;
                        int end = Math.min(start + finalI, toString().length());
                        return id.toString().substring(start, end);
                    })
                    .toList();
            for (int j = 0; j < listOfChunks.size() - 1; j++) {
                if (listOfChunks.get(j).equals(listOfChunks.get(j + 1))) {
                    return true;
                }
            }
        }
        return false;
    }
}
