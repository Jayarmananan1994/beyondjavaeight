package com.vjay.beyondeight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java15MethodTest {

    @Test
    void testTextBlock() {
        String bigBlockWithNewLine = """
                You're not brave... "men are brave".
                You say that you want to help people, but you can't feel their pain... their mortality...
                It's time you learn what it means to be a man.
                """;
        var expected = "You're not brave... \"men are brave\".\n"
                + "You say that you want to help people, but you can't feel their pain... their mortality...\n"
                + "It's time you learn what it means to be a man.\n";
        assertEquals(expected, bigBlockWithNewLine);
    }

    @Test
    void shouldGiveSingleLineTextBlock() {
        String bigBlockWithNewLine = """
                I'm older now than my father ever was. \
                This may be the only thing I do that matters\
                """;
        var expected = "I'm older now than my father ever was. This may be the only thing I do that matters";
        assertEquals(expected, bigBlockWithNewLine);
    }

    @Test
    void shouldPreserveLeadingSpace() {
        String textWithleadingSpace = """
                <h1>
                     Some title
                </h1>""";
        String expected = "<h1>\n" + "     Some title\n" + "</h1>";
        assertEquals(expected, textWithleadingSpace);
    }

    @Test
    void shouldTrimTrailingSpace() {
        String textWithleadingSpace = """
                <h1>
                     Some title      
                </h1>""";
        String expected = "<h1>\n" + "     Some title\n" + "</h1>";
        assertEquals(expected, textWithleadingSpace);
    }
}
