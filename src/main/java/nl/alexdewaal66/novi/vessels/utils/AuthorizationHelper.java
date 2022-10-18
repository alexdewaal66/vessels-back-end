package nl.alexdewaal66.novi.vessels.utils;

import nl.alexdewaal66.novi.vessels.model.Enduser;
import nl.alexdewaal66.novi.vessels.model.Role;
import nl.alexdewaal66.novi.vessels.service.EnduserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;

enum Level {
    NONE, ROLE_MEMBER, ROLE_EXPERT, ROLE_ADMIN, ROLE_DEMIURG;

    public boolean greaterThan(Level other) {
        return this.compareTo(other) > 0;
    }
}

@Service
public class AuthorizationHelper {
    @Autowired
    EnduserService enduserService;

    public boolean isEligible(String username) {
        String principal = getPrincipalName();
        return username == null || principal.equals(username) || hasPrincipalHigherRoleThan(username);
    }

    public boolean isSelf(String username) {
        Authentication auth = getAuth();
        String principal = getPrincipalName(auth);
        return principal.equals(username);
    }
    public boolean isSelfOrAdmin(String username) {
        Authentication auth = getAuth();
        String principal = getPrincipalName(auth);
        return principal.equals(username) || checkRole(auth, Role.Roles.ADMIN.label);
    }

    private boolean hasPrincipalHigherRoleThan(String username) {
        return getHighestLevel(null).greaterThan(getHighestLevel(username));
    }

    private Level getHighestLevel(String username) {
        final var ref = new Object() {
            Level highest = Level.ROLE_MEMBER;
        };
        Set<String> roles = getRoles(username);
        roles.forEach(role -> {
            Level level = Level.NONE;
            try {
                level = Level.valueOf(role);
            } finally {
                if (level.greaterThan(ref.highest)) ref.highest = level;
            }
        });
        return ref.highest;
    }

    private Set<String> getRoles(String username) {
        if (username == null) {
            return getAuth().getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toSet());
        } else {
            Enduser Enduser = (Enduser) enduserService.loadUserByUsername(username);
            return Enduser.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        }
    }

    public String getPrincipalName(Authentication auth) {
        return auth.getName();
    }

    public String getPrincipalName() {
        return getAuth().getName();
    }

    private Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public boolean checkRole(String roleName) {
        return checkRole(getAuth(), roleName);
    }


    public boolean checkRole(Authentication auth, String roleName) {
//        logv("checkRole(" + roleName + ")", "auth=" + auth);
        return auth != null &&
                auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(roleName));
    }

}
