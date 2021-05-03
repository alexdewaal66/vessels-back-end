package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Pqr;

import java.util.Collection;

public interface PqrService {

    long createPqr(Pqr pqr);

    Collection<Pqr> getPqrs();
    Pqr getPqrById(long id);
    Pqr getPqrByPqrString(String pqrString);

    void updatePqr(long id, Pqr pqr);

    void deletePqr(long id);

    boolean pqrExists(long id);

}
