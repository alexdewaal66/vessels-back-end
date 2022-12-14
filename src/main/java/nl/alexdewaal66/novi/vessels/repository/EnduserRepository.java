package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Enduser;
import nl.alexdewaal66.novi.vessels.model.EnduserComplete;
import nl.alexdewaal66.novi.vessels.model.EnduserRestricted;
import nl.alexdewaal66.novi.vessels.model.EnduserSummary;

import java.util.Collection;
import java.util.Optional;

public interface EnduserRepository extends GenericRepository<Enduser> {
    Collection<EnduserSummary> findAllSummariesBy();
    Collection<EnduserSummary> findSummariesByIdIn(Collection<Long> ids);

    Collection<EnduserRestricted> findAllRestrictedBy();
    Collection<EnduserComplete> findAllCompleteBy();
    EnduserRestricted getRestrictedById(Long id);
    EnduserComplete getCompleteById(Long id);
    Optional<Enduser> findByUsername(String username);
}
