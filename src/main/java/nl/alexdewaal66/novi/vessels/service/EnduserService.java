package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericService;
import nl.alexdewaal66.novi.vessels.model.Enduser;
import nl.alexdewaal66.novi.vessels.model.EnduserRestricted;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public interface EnduserService
        extends GenericService<Enduser>, UserDetailsService  {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

//    EnduserRestricted getRestrictedByName(String name);

//    EnduserComplete getCompleteByName(String name);

    Collection<EnduserRestricted> getAllRestricted();

    //    Collection<EnduserComplete> getAllComplete();


    EnduserRestricted getRestricted(Long id);
//    EnduserComplete getComplete(Long id);

    Long create(Enduser item);

    Object update(Long id, Enduser newItem);
}
