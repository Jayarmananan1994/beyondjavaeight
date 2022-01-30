package com.vjay.beyondeight;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Java17Test {

    @Test
    void shouldCreateRecord() {
        var dave = new Person("Dave batista", "Royal rumble");
        assertEquals("Dave batista", dave.name());
        assertEquals("Royal rumble", dave.address());
    }

    @Test
    void localRecordClass() {
        int dummyVar = 10;
        record LocalPerson(String name, int age) {
            LocalPerson {
                // dummyVar -> cannot access variable present in enclosing method.
            }
        }
        class SecondLocalPerson {
            void access() {
                if (dummyVar > 10)
                    System.out.println("I can see you");
            }
        }
    }

    @Test
    void deserializingRecord() throws JsonProcessingException {
        var rangeStr = """
                { "start": 10, "end": 5}
                 """;
        ObjectMapper objectMapper = new ObjectMapper();
        assertThrows(ValueInstantiationException.class,
                () -> objectMapper.readValue(rangeStr, Range.class));
        var rangeObj = objectMapper.readValue(rangeStr, RangeMiko.class);
        assertTrue(rangeObj.end < rangeObj.start);
    }

    record Range(int start, int end) {
        Range {
            if (start > end)
                throw new RuntimeException("Start cannot be greater than end");
        }
    }

    static class RangeMiko {
        private int start;
        private int end;

        public RangeMiko() {
        }

        public RangeMiko(int start, int end) {
            if (start > end)
                throw new RuntimeException("Start cannot be greater than end");
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    record Person(String name, String address) {
    }

}
