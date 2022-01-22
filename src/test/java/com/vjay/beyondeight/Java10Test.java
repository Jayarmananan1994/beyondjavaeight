package com.vjay.beyondeight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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
