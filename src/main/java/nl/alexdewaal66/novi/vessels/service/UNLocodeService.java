package nl.alexdewaal66.novi.vessels.service;

import java.util.Collection;
import nl.alexdewaal66.novi.vessels.model.UNLocode;

public interface UNLocodeService {
    Collection<UNLocode> getUNLocodes();
    UNLocode getUNLocodeById(long id);
    UNLocode getUNLocodeByCodes(String alpha2Code, String locationCode);
    UNLocode getUNLocodeByName(String name);

    boolean unLocodeExists(long id);

}
