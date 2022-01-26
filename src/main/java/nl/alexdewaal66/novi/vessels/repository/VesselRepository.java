package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Vessel;
import nl.alexdewaal66.novi.vessels.model.VesselSummary;

import java.util.Collection;

public interface VesselRepository extends GenericRepository<Vessel> {

    Collection<VesselSummary> findAllSummariesBy();

    Collection<VesselSummary> findSummariesByIdIn(Collection<Long> ids);

}
