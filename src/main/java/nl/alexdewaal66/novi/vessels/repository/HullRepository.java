package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Hull;
import nl.alexdewaal66.novi.vessels.model.HullSummary;

import java.util.Collection;

public interface HullRepository extends GenericRepository<Hull> {

    Collection<HullSummary> findAllSummariesBy();

    Collection<HullSummary> findSummariesByIdIn(Collection<Long> ids);

}
