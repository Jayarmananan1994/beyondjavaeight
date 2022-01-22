package com.vjay.beyondeight;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
import static java.util.Map.of;
import static java.util.Map.ofEntries;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java9Test {

    @Test
    void useOfMapOf() {
        Map myMap = of("K1", "Some val for K",
                "G1", "Some val for G1");
        Map bigMap = ofEntries(
                entry("one", "asd"),
                entry("two", "asd"),
                entry("three", "asd"),
                entry("four", "asd"),
                entry("five", "asd"),
                entry("six", "asd"),
                entry("seven", "asd"),
                entry("eight", "asd"),
                entry("nine", "asd"),
                entry("ten", "asd"),
                entry("eleven", "asd")
        );
        assertEquals("Some val for G1", myMap.get("G1"));
    }

    @Test
    void newSwitch() {
        String heroName = "as";
        printHeroDescription(heroName);
    }

    private void printHeroDescription(String name) {
        String heroDesc = switch (name) {
            case "Supes" -> {
                String gg  = "";
                yield  "Man of steel";
            }
            case "Batsy" -> "A great detective";
            case "WonderWoman" -> "Demi goddess";
            case "Flash", "QuickSilver" -> "Runs fast";
            default -> "Not available right now";
        };
        System.out.println(heroDesc);
    }
}
