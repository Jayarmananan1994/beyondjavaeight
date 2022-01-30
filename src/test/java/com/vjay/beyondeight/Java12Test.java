package com.vjay.beyondeight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Java12Test {

    @Test
    void teeingExample() {
        var numbers = List.of(
                new Player("A", 100),
                new Player("B", 431),
                new Player("C", 234),
                new Player("D", 544),
                new Player("E", 84)
        );

        MinMax minMax = numbers.stream().collect(Collectors.teeing(
                Collectors.minBy(Comparator.comparing(Player::points)),
                Collectors.maxBy(Comparator.comparing(Player::points)),
                (min, max) -> new MinMax(min.get(), max.get())
        ));

        Assertions.assertEquals("E", minMax.min.name);
        Assertions.assertEquals("D", minMax.max.name);
    }

    //permanent feature in Java 17 though
    record MinMax(Player min, Player max) { }

    record Player(String name, int points) { }
}
