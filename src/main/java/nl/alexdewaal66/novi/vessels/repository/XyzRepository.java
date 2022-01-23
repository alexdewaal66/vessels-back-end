package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics2.GenericRepository2;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.model.XyzSummaryInterface;
import nl.alexdewaal66.novi.vessels.model.XyzSummaryProjection;
import nl.alexdewaal66.novi.vessels.model.ZyxSummaryInterface;

import java.util.Collection;

public interface XyzRepository extends GenericRepository2<Xyz> {

    Collection<XyzSummaryInterface> getAllBy();

    Collection<XyzSummaryInterface> getAllByIdIn(Collection<Long> ids);

}
