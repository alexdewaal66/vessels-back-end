package nl.alexdewaal66.novi.vessels.repository;
import nl.alexdewaal66.novi.vessels.generics2.GenericRepository2;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.model.ZyxSummaryInterface;
import nl.alexdewaal66.novi.vessels.model.ZyxSummaryProjection;

import java.util.Collection;

public interface ZyxRepository extends GenericRepository2<Zyx> {
    Zyx findByName(String name);

    Collection<ZyxSummaryInterface> getAllBy();

    Collection<ZyxSummaryInterface> getAllByIdIn(Collection<Long> ids);
}
