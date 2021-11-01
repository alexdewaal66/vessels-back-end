package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Zyx;

import java.util.Collection;
import java.util.List;

public interface ZyxService extends GenericService<Zyx> {

    Zyx getZyxByName(String Name);

}
