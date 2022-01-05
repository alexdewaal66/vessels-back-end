package nl.alexdewaal66.novi.vessels.service;

import java.util.Collection;
import java.util.List;

import nl.alexdewaal66.novi.vessels.generics.GenericService;
import nl.alexdewaal66.novi.vessels.model.UNLocode;
import nl.alexdewaal66.novi.vessels.model.Xyz;

public interface UNLocodeService extends GenericService<UNLocode> {

    UNLocode getUNLocodeByCodes(String alpha2Code, String locationCode);
    UNLocode getUNLocodeByName(String name);

}
