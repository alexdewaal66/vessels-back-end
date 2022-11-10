package nl.alexdewaal66.novi.vessels.utils;

import static org.junit.jupiter.api.Assertions.*;

import nl.alexdewaal66.novi.vessels.model.Enduser;
import nl.alexdewaal66.novi.vessels.model.Role;
import nl.alexdewaal66.novi.vessels.service.EnduserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@ContextConfiguration
@DisplayName("AuthorizationHelper")
class AuthorizationHelperTest {

    Enduser getUser(String name, Level level) {
        Role role = new Role();
        role.setName(level.name());
        Enduser enduser = new Enduser();
        enduser.setUsername(name);
        enduser.setRoles(new HashSet<>(List.of(role)));
        return enduser;
    }

    @InjectMocks
    private AuthorizationHelper authorizationHelperMock;

    @Mock
    private EnduserService enduserServiceMock;

    @Nested
    @DisplayName("isEligible: does Principal be or outrank provided user")
    class isEligible {

        @Test
        @WithMockUser(username = "Alice", roles = {"MEMBER", "ADMIN", "DEMIURG"})
        @DisplayName("when there's no provided user")
        void whenUsernameIsNull() {
            // act
            boolean whenUsernameIsNull = authorizationHelperMock.isEligible(null);
            // assert
            assertTrue(whenUsernameIsNull);
        }

        @Test
        @WithMockUser(username = "Alice")
        @DisplayName("when provided user is the principal's")
        void whenUsernameIsPrincipal() {
            // act
            boolean whenPrincipal = authorizationHelperMock.isEligible("Alice");
            // assert
            assertTrue(whenPrincipal);
        }

        @Test
        @WithMockUser(username = "Alice", roles = {"MEMBER", "ADMIN", "DEMIURG"})
        @DisplayName("when principal has higher role than provided user")
        void whenPrincipalHasHigherRole() {
            // arrange
            Mockito.when(enduserServiceMock.loadUserByUsername("Bob"))
                    .thenReturn(getUser("Bob", Level.ROLE_EXPERT));
            // act
            boolean whenPrincipalOutranksProvided = authorizationHelperMock.isEligible("Bob");
            // assert
            assertTrue(whenPrincipalOutranksProvided);
        }

        @Test
        @WithMockUser(username = "Alice", roles = {"MEMBER"})
        @DisplayName("when principal has lower role than provided user")
        void whenPrincipalHasLowerRole() {
            // arrange
            Mockito.when(enduserServiceMock.loadUserByUsername("Bob"))
                    .thenReturn(getUser("Carol", Level.ROLE_ADMIN));
            // act
            boolean whenProvidedOutranksPrincipal = authorizationHelperMock.isEligible("Bob");
            // assert
            assertFalse(whenProvidedOutranksPrincipal);
        }
    }

    @Test
    @WithMockUser(username = "current-user")
    @DisplayName("isSelf:  should return true when provided user is principal")
    void isSelf_shouldReturnTrue_whenUsernameIsFromPrincipal() {
        // arrange
        // act
        boolean whenOtherUser = authorizationHelperMock.isSelf("another-user");
        boolean whenPrincipal = authorizationHelperMock.isSelf("current-user");
        // assert
        assertFalse(whenOtherUser);
        assertTrue(whenPrincipal);
    }


    @Test
    @WithMockUser(username = "currentUser")
    @DisplayName("getPrincipalName: should return the principal's username")
    void getPrincipalName() {
        // arrange
        // act
        String actual = authorizationHelperMock.getPrincipalName();
        // assert
        assertEquals("currentUser", actual);
    }

    @Test
    @WithMockUser(username = "Alice", roles = {"MEMBER", "ADMIN"})
    @DisplayName("checkRole: checks if principal provided role")
    void checkRole() {
        // act
        boolean aliceIsAdmin = authorizationHelperMock.checkRole("ROLE_ADMIN");
        boolean aliceIsMember = authorizationHelperMock.checkRole("ROLE_MEMBER");
        boolean aliceIsMadeUpRoleName = authorizationHelperMock.checkRole("MADE-UP-ROLE-NAME");
        // assert
        assertTrue(aliceIsAdmin);
        assertTrue(aliceIsMember);
        assertFalse(aliceIsMadeUpRoleName);
    }


}
// arrange
// act
// assert
