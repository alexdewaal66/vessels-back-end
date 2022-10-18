package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.TestType;
import nl.alexdewaal66.novi.vessels.model.TestTypeSummary;

import java.util.Collection;

public interface TestTypeRepository
        extends GenericRepository<TestType> {

    TestType findByNameENContainsOrNameNLContains(String nameEN, String nameNL);

    Collection<TestTypeSummary> findAllSummariesBy();

    Collection<TestTypeSummary> findSummariesByIdIn(Collection<Long> ids);
}
