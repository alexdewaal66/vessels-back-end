package nl.alexdewaal66.novi.vessels.repository;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Role;
import nl.alexdewaal66.novi.vessels.model.RoleSummary;
import java.util.Collection;

public interface RoleRepository extends GenericRepository<Role> {
    Collection<RoleSummary> findAllSummariesBy();
    Collection<RoleSummary> findSummariesByIdIn(Collection<Long> ids);
}
