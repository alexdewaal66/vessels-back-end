package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Organisation;
import nl.alexdewaal66.novi.vessels.model.OrganisationSummary;

import java.util.Collection;

public interface OrganisationRepository extends GenericRepository<Organisation> {

    Collection<OrganisationSummary> findAllSummariesBy();

    Collection<OrganisationSummary> findSummariesByIdIn(Collection<Long> ids);

}
