package com.pp.java.features.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {

    @Test
    public void teeingCollector() {
        var numbers = IntStream.range(0, 100).boxed();

        // TODO rewrite using new api https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/stream/Collectors.html#teeing(java.util.stream.Collector,java.util.stream.Collector,java.util.function.BiFunction)
        var minIndex = 0;
        var maxIndex = 1;
        var range = numbers.collect(
                () -> new int[] { MAX_VALUE, MIN_VALUE },
                (minMax, i) -> {
                    if (i < minMax[minIndex]) {
                        minMax[minIndex] = i;
                    }
                    if (i > minMax[maxIndex]) {
                        minMax[maxIndex] = i;
                    }
                },
                (minMax1, minMax2) -> {
                    if (minMax2[minIndex] < minMax1[minIndex]) {
                        minMax1[minIndex] = minMax2[minIndex];
                    }
                    if (minMax2[maxIndex] > minMax1[maxIndex]) {
                        minMax1[maxIndex] = minMax2[maxIndex];
                    }
                });

        assertEquals(99, range[1] - range[minIndex]);
    }

}
