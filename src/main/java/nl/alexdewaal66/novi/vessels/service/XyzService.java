package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Xyz;

import java.util.Collection;

public interface XyzService {

    long createXyz(Xyz xyz);

    Collection<Xyz> getXyzs();
    Xyz getXyzById(long id);
    Xyz getXyzByXyzString(String xyzString);

    void updateXyz(long id, Xyz xyz);

    void deleteXyz(long id);

    boolean xyzExists(long id);

}
