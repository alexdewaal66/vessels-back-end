package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.PropulsionType;
import nl.alexdewaal66.novi.vessels.model.PropulsionTypeSummary;

import java.util.Collection;

public interface PropulsionTypeRepository
        extends GenericRepository<PropulsionType>
{

    Collection<PropulsionTypeSummary> findAllSummariesBy();

    Collection<PropulsionTypeSummary> findAllSummariesByIdIn(Collection<Long> ids);

}
