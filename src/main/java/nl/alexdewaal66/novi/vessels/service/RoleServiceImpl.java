package nl.alexdewaal66.novi.vessels.service;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Role;
import nl.alexdewaal66.novi.vessels.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl
        extends GenericServiceImpl<Role> implements RoleService {
    public RoleServiceImpl(RoleRepository repository) {
        super(repository, "Role");
    }
}
