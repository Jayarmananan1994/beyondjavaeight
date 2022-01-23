package com.vjay.beyondeight;

import org.junit.jupiter.api.Test;

public class Java14Test {

    @Test
    void newSwitch() {
        String heroName = "as";
        printHeroDescription(heroName);
    }

    private void printHeroDescription(String name) {
        String heroDesc = switch (name) {
            case "Supes" -> {
                String gg = "";
                yield "Man of steel";
            }
            case "Batsy" -> "A great detective";
            case "WonderWoman" -> "Demi goddess";
            case "Flash", "QuickSilver" -> "Runs fast";
            default -> "Not available right now";
        };
        System.out.println(heroDesc);
    }
}
