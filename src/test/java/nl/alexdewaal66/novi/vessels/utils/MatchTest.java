package nl.alexdewaal66.novi.vessels.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTest {

     static class Something {
         String string;
        public Something(String s) {
            string = s;
        }
    }

    @Test
    @DisplayName("setMode: mode is provided String")
    void setMode_modeIsProvidedString() {
        // arrange
        Match<String> sMatch = new Match<>();
        // act
        sMatch.setMode("test-string-0");
        String actual = sMatch.mode;
        // assert
        assertEquals("test-string-0", actual);
    }

    @Test
    @DisplayName("setProbe: probe is provided String")
    void setProbe_probeIsProvidedString() {
        // arrange
        Match<String> match = new Match<>();
        // act
        match.setProbe("test-string-1");
        String actual = match.probe;
        // assert
        assertEquals("test-string-1", actual);
    }

    @Test
    @DisplayName("setProbe: probe is provided Something object")
    void setProbe_probeIsProvidedXInstance() {
        // arrange
        Something something = new Something("test-string-2");
        Match<Something> match = new Match<>();
        // act
        match.setProbe(something);
        String actual = match.probe.string;
        // assert
        assertEquals("test-string-2", actual);
    }
}
