package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.model.VesselTypeSummary;

import java.util.Collection;

public interface VesselTypeRepository
        extends GenericRepository<VesselType>
{

    VesselType findByNameENContainsOrNameNLContains(String nameEN, String nameNL);

    Collection<VesselTypeSummary> findAllSummariesBy();

    Collection<VesselTypeSummary> findSummariesByIdIn(Collection<Long> ids);

}
