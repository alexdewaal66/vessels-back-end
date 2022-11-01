package nl.alexdewaal66.novi.vessels.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MatcherTest {
    private final List<String> props = Arrays.asList("nl", "en");

    @Test
    @DisplayName("build: constructs Matcher on _all_ props")
    void build_constructsMatcherOnAllProps() {
        // arrange
        Set<String> expectedIgnoredPaths = new HashSet<>(List.of("id"));
        // act
        ExampleMatcher matcher = Matcher.build("all", props);
        // assert
        assertEquals(ExampleMatcher.NullHandler.IGNORE, matcher.getNullHandler());
        assertEquals(ExampleMatcher.StringMatcher.DEFAULT, matcher.getDefaultStringMatcher());
        assertEquals(expectedIgnoredPaths, matcher.getIgnoredPaths());
        assertEquals("TypedExampleMatcher", matcher.getClass().getSimpleName());
        assertEquals(ExampleMatcher.MatchMode.ALL, matcher.getMatchMode());
    }

    @Test
    @DisplayName("build: constructs Matcher on _any_ prop")
    void build_constructsMatcherOnAnyProp() {
        // arrange
        Set<String> expectedIgnoredPaths = new HashSet<>(List.of("id"));
        // act
        ExampleMatcher matcher = Matcher.build("any", props);
        // assert
        assertEquals(ExampleMatcher.NullHandler.IGNORE, matcher.getNullHandler());
        assertEquals(ExampleMatcher.StringMatcher.DEFAULT, matcher.getDefaultStringMatcher());
        assertEquals(expectedIgnoredPaths, matcher.getIgnoredPaths());
        assertEquals("TypedExampleMatcher", matcher.getClass().getSimpleName());
        assertEquals(ExampleMatcher.MatchMode.ANY, matcher.getMatchMode());
    }
}
// arrange
// act
// assert
