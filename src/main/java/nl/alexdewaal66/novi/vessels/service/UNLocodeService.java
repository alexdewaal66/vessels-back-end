package nl.alexdewaal66.novi.vessels.service;

import java.util.Collection;
import java.util.List;

import nl.alexdewaal66.novi.vessels.model.UNLocode;
import nl.alexdewaal66.novi.vessels.model.Xyz;

public interface UNLocodeService {

    Collection<Long> getAllIds();
    Collection<UNLocode> getUNLocodes();
    List<UNLocode> getByIds(List<Long> ids);
    UNLocode getUNLocodeById(long id);
    UNLocode getUNLocodeByCodes(String alpha2Code, String locationCode);
    UNLocode getUNLocodeByName(String name);

    boolean unLocodeExists(long id);

}
