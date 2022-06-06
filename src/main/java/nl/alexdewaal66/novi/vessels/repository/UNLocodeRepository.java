package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.UNLocode;
import nl.alexdewaal66.novi.vessels.model.UNLocodeSummary;

import java.util.Collection;

public interface UNLocodeRepository extends GenericRepository<UNLocode> {

    UNLocode findByAlpha2CodeAndLocationCode(String alpha2Code, String locationCode);

    UNLocode findByNameDiacriticsContainsOrNameWoDiacriticsContains(String name, String nameWo);

    Collection<UNLocodeSummary> findAllSummariesBy();

    Collection<UNLocodeSummary> findSummariesByIdIn(Collection<Long> ids);

}
