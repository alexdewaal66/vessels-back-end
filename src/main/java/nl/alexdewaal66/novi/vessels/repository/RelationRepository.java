package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Relation;
import nl.alexdewaal66.novi.vessels.model.RelationSummary;

import java.util.Collection;

public interface RelationRepository extends GenericRepository<Relation> {

    Collection<RelationSummary> findAllSummariesBy();

    Collection<RelationSummary> findSummariesByIdIn(Collection<Long> ids);

}
