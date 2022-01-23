package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics2.GenericService2;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.model.ZyxSummaryProjection;

import java.util.Collection;

public interface ZyxService extends GenericService2<Zyx> {

    Zyx getZyxByName(String Name);
}
