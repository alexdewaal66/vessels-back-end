package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericService;
import nl.alexdewaal66.novi.vessels.model.UNLocode;

public interface UNLocodeService extends GenericService<UNLocode> {

    UNLocode getUNLocodeByCodes(String alpha2Code, String locationCode);
    UNLocode getUNLocodeByName(String name);

}
