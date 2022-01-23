package com.vjay.beyondeight;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Java10Test {

    @Test
    void useOfVar() {
        var someText = "Random text";
        var map = new HashMap<String, String>();
        assertTrue(someText instanceof String);
        assertTrue(map instanceof Map);
        assertTrue(map instanceof HashMap);
    }

}
