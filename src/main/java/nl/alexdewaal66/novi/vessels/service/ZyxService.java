package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericService;
import nl.alexdewaal66.novi.vessels.model.Zyx;

public interface ZyxService extends GenericService<Zyx> {

    Zyx getZyxByName(String Name);
}
