package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.model.XyzSummary;

import java.util.Collection;

public interface XyzRepository extends GenericRepository<Xyz> {

    Collection<XyzSummary> findAllSummariesBy();

    Collection<XyzSummary> findSummariesByIdIn(Collection<Long> ids);

}
