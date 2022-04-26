package nl.alexdewaal66.novi.vessels.repository;
import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.model.ZyxSummary;

import java.sql.Timestamp;
import java.util.Collection;

public interface ZyxRepository extends GenericRepository<Zyx> {
    Zyx findByName(String name);

    Collection<ZyxSummary> findAllSummariesBy();

    Collection<ZyxSummary> findSummariesByIdIn(Collection<Long> ids);

}
