package nl.alexdewaal66.novi.vessels.utils;

import static org.junit.jupiter.api.Assertions.*;

import nl.alexdewaal66.novi.vessels.model.Enduser;
import nl.alexdewaal66.novi.vessels.model.Role;
import nl.alexdewaal66.novi.vessels.service.EnduserService;
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
class AuthorizationHelperTest {

    @InjectMocks
    private AuthorizationHelper authorizationHelperMock;

    @Mock
    private EnduserService enduserServiceMock;

    @Nested
    class isEligible {

        @Test
        @WithMockUser(username = "Alice", roles = {"MEMBER", "ADMIN", "DEMIURG"})
        void whenUsernameIsNull() {
            // act
            boolean whenUsernameIsNull = authorizationHelperMock.isEligible(null);
            // assert
            assertTrue(whenUsernameIsNull);
        }

        @Test
        @WithMockUser(username = "Alice")
        void whenUsernameIsPrincipal() {
            // act
            boolean whenPrincipal = authorizationHelperMock.isEligible("Alice");
            // assert
            assertTrue(whenPrincipal);
        }

        @Test
        @WithMockUser(username = "Alice", roles = {"MEMBER", "ADMIN", "DEMIURG"})
        void whenPrincipalHasHigherRole() {
            // arrange
            Role expert = new Role();
            expert.setName(Level.ROLE_EXPERT.name());
            Enduser bob = new Enduser();
            bob.setUsername("Bob");
            bob.setRoles(new HashSet<>(List.of(expert)));

            Mockito.when(enduserServiceMock.loadUserByUsername("Bob")).thenReturn(bob);
            // act
            boolean whenPrincipalOutranksProvided = authorizationHelperMock.isEligible("Bob");
            // assert
            assertTrue(whenPrincipalOutranksProvided);
        }

        @Test
        @WithMockUser(username = "Alice", roles = {"MEMBER"})
        void whenPrincipalHasLowerRole() {
            // arrange
            Role expert = new Role();
            expert.setName(Level.ROLE_EXPERT.name());
            Enduser bob = new Enduser();
            bob.setUsername("Bob");
            bob.setRoles(new HashSet<>(List.of(expert)));

            Mockito.when(enduserServiceMock.loadUserByUsername("Bob")).thenReturn(bob);
            // act
            boolean whenProvidedOutranksPrincipal = authorizationHelperMock.isEligible("Bob");
            // assert
            assertFalse(whenProvidedOutranksPrincipal);
        }
    }

    @Test
    @WithMockUser(username = "current-user")
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
    void getPrincipalName() {
        // arrange
        // act
        String actual = authorizationHelperMock.getPrincipalName();
        // assert
        assertEquals("currentUser", actual);
    }

    @Test
    @WithMockUser(username = "Alice", roles = {"MEMBER", "ADMIN"})
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
