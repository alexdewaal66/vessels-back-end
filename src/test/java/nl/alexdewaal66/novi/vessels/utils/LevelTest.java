package nl.alexdewaal66.novi.vessels.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    @Test
    @DisplayName("greaterThan: checks if subject outranks argument")
    void greaterThan() {
        // arrange
        Level member = Level.ROLE_MEMBER;
        Level expert = Level.ROLE_EXPERT;
        // act
        boolean superior = expert.greaterThan(member);
        boolean inferior = member.greaterThan(expert);
        boolean equal = member.greaterThan(member);
        // assert
        assertTrue(superior);
        assertFalse(inferior);
        assertFalse(equal);
    }

}
// arrange
// act
// assert
