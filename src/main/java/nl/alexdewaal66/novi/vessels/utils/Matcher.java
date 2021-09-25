package nl.alexdewaal66.novi.vessels.utils;

import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

public class Matcher {
    public static ExampleMatcher build(String matchMode, List<String> properties) {
        ExampleMatcher matcher;
        if (matchMode.equals("any")) {
            matcher = ExampleMatcher.matchingAny();
        } else {
            matcher = ExampleMatcher.matchingAll();
        }
        matcher = matcher.withIgnorePaths("id").withIgnoreCase();
        for (String property : properties) {
            matcher = matcher.withMatcher(property,
                    ExampleMatcher.GenericPropertyMatchers.contains());
        }
        return matcher;
    }
}
