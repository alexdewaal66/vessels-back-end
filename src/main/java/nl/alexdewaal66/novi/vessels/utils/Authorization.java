package nl.alexdewaal66.novi.vessels.utils;

import nl.alexdewaal66.novi.vessels.model.Authority;
import nl.alexdewaal66.novi.vessels.model.User;
import nl.alexdewaal66.novi.vessels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

enum Level {
    ROLE_MEMBER, ROLE_EXPERT, ROLE_ADMIN;

    public boolean greaterThan(Level other) {
        return this.compareTo(other) > 0;
    }
}

@Service
public class Authorization {

    @Autowired
    UserService userService;

    public boolean isEligible(String owner) {
        String principal = getPrincipalName();
        return owner == null || principal.equals(owner) || hasPrincipalHigherRoleThan(owner);
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
            Level level = Level.valueOf(role);
            if (level.greaterThan(ref.highest)) ref.highest = level;
        });
        return ref.highest;
    }

    private Set<String> getRoles(String username) {
        if (username == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return auth.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toSet());
        } else {
            Set<Authority> authoritySet = userService.getAuthorities(username);
            return authoritySet.stream().map(Authority::getRole)
                    .collect(Collectors.toSet());
        }
    }

    public String getPrincipalName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public boolean checkRole(String authName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(authName));
    }

}
