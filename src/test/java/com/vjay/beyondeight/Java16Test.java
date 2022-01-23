package com.vjay.beyondeight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Java16Test {

    @Test
    void checkPatternMatchingWithInstanceOf() {
        Object someVal = "Some val";
        if (someVal instanceof String s) {
            Assertions.assertTrue(someVal instanceof String);
            Assertions.assertEquals("Some val", someVal);
        }
    }

}
