package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.RelationType;
import nl.alexdewaal66.novi.vessels.model.RelationTypeSummary;

import java.util.Collection;

public interface RelationTypeRepository extends GenericRepository<RelationType> {

    Collection<RelationTypeSummary> findAllSummariesBy();

    Collection<RelationTypeSummary> findSummariesByIdIn(Collection<Long> ids);
}
