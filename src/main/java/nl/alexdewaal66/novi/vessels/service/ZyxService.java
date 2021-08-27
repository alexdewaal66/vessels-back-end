package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Zyx;
import java.util.Collection;

public interface ZyxService {

    Collection<Zyx> getZyxs();
    Zyx getZyxById(long id);
    Zyx getZyxByName(String Name);

    long createZyx(Zyx zyx);

    void updateZyx(long id, Zyx zyx);

    void deleteZyx(long id);

    boolean zyxExists(long id);
}
