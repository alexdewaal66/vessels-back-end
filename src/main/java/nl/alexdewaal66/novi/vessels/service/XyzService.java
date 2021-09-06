package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Xyz;
import java.util.Collection;
import java.util.List;

public interface XyzService {

    Collection<Long> getAllIds();
    Collection<Xyz> getXyzs();
    List<Xyz> getByIds(List<Long> ids);
    Xyz getXyzById(long id);
    Xyz getXyzByXyzString(String xyzString);

    long createXyz(Xyz xyz);

    void updateXyz(long id, Xyz xyz);

    void deleteXyz(long id);

    boolean xyzExists(long id);

}
