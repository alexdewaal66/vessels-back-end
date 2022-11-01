package nl.alexdewaal66.novi.vessels.utils;

import nl.alexdewaal66.novi.vessels.model.Enduser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtUtilTest {

    @Autowired
    JwtUtil jwtUtil;

    @Test
    @DisplayName("generateToken: produces JWT")
    void generateToken_producesJWT() {
        // arrange
        Enduser enduser = new Enduser();
        enduser.setUsername("Dummy");
        // act
        String jwt = jwtUtil.generateToken(enduser);
        // assert
        String header = jwt.substring(0, jwt.indexOf('.'));
        assertEquals("eyJhbGciOiJIUzI1NiJ9", header);
    }

    @Test
    @DisplayName("extractUsername: extracted username must equal name provided in generation")
    void extractUsername_extractedNameEqualsProvidedInGeneration() {
        // arrange
        Enduser enduser = new Enduser();
        enduser.setUsername("TestName");
        String jwt = jwtUtil.generateToken(enduser);
        // act
        String name = jwtUtil.extractUsername(jwt);
        // assert
        assertEquals("TestName", name);
    }

    @Test
    @DisplayName("validateToken: username in JWT must equal name in provided userDetails")
    void validateToken_usernameInJwtMustEqualNameInUserDetails() {
        // arrange
        Enduser realUser = new Enduser();
        realUser.setUsername("RealUser");
        Enduser fakeUser =  new Enduser();
        fakeUser.setUsername("FakeUser");
        String jwt = jwtUtil.generateToken(realUser);
        // act
        Boolean legitimate = jwtUtil.validateToken(jwt, realUser);
        Boolean fraudulent = jwtUtil.validateToken(jwt, fakeUser);
        // assert
        assertTrue(legitimate);
        assertFalse(fraudulent);
    }
}
// arrange
// act
// assert

// eyJhbGciOiJIUzI1NiJ9.
// eyJzdWIiOiJUZXN0TmFtZSIsImV4cCI6MTY2NzcyMTQ2NywiaWF0IjoxNjY2ODU3NDY3fQ.
// 3FmCQRpGWXV8xQQagoCyt5J5T8I-7Bm66tH0Eh8B2KA

// eyJhbGciOiJIUzI1NiJ9.
// eyJzdWIiOiJUZXN0TmFtZSIsImV4cCI6MTY2NzcyMTYzOCwiaWF0IjoxNjY2ODU3NjM4fQ.
// GVaxAfXZH1jolSjIwhakQtboSU0QeT1wUCUFmooeksc