package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Enduser;
import nl.alexdewaal66.novi.vessels.model.EnduserComplete;
import nl.alexdewaal66.novi.vessels.model.EnduserRestricted;
import nl.alexdewaal66.novi.vessels.model.Role;
import nl.alexdewaal66.novi.vessels.repository.EnduserRepository;
import nl.alexdewaal66.novi.vessels.utils.AuthorizationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;

@Service
public class EnduserServiceImpl
        extends GenericServiceImpl<Enduser>
        implements EnduserService {

    final EnduserRepository enduserRepository;

    @Autowired
    AuthorizationHelper authorizationHelper;

    @Autowired
    RoleService roleService;

    public EnduserServiceImpl(EnduserRepository repository, EnduserRepository enduserRepository) {
        super(repository, "Enduser");
        this.enduserRepository = enduserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Enduser> enduserDetails = enduserRepository.findByUsername(username);
        if (enduserDetails.isEmpty()) throw new UsernameNotFoundException(username);
        return enduserDetails.get();
    }

    @Override
    public Collection<EnduserRestricted> getAllRestricted() {
        return enduserRepository.findAllRestrictedBy();
    }
    @Override
    public Collection<EnduserComplete> getAllComplete() {
        return enduserRepository.findAllCompleteBy();
    }

    @Override
    public EnduserRestricted getRestricted(Long id) {
        return enduserRepository.getRestrictedById(id);
    }
    @Override
    public EnduserComplete getComplete(Long id) {
        return enduserRepository.getCompleteById(id);
    }

    @Override
    public Long create(Enduser item) {
        if (authorizationHelper.checkRole(Role.Roles.ADMIN.label)) {
            // no-one can get role DEMIURG
            noDemiurg(item);
            return super.create(item);
        } else {
            logv("EnduserServiceImpl » create()",
                    "item" + item);
            Role role = roleService.getById(Role.Roles.MEMBER.id);
            item.setRoles(Set.of(role));
            return super.create(item);
        }
    }

    @Override
    public Object update(Long id, Enduser item) {
        Enduser oldItem = getById(id);
        boolean isAdmin = authorizationHelper.checkRole(Role.Roles.ADMIN.label);
        boolean isSelf = authorizationHelper.isSelf(oldItem.getUsername());
        if (isAdmin && !isSelf) {
            // admin can't change another users password
            item.setPassword(oldItem.getPassword());
            // no-one can get role DEMIURG
            noDemiurg(item);
        }
        if (isSelf) {
            // can't change your own roles
            item.setRoles(oldItem.getRoles());
        }
        return (isAdmin || isSelf)
                ? super.update(id, item)
                : null;
    }

    private void noDemiurg(Enduser user) {
        Set<Role> roles = user.getRoles();
        roles.removeIf((Role role) -> role.getName().equals(Role.Roles.DEMIURG.label));
        user.setRoles(roles);
    }

}
