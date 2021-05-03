package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.IncompleteRecordException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.Pqr;
import nl.alexdewaal66.novi.vessels.repository.PqrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PqrServiceImpl implements PqrService {

    @Autowired
    private PqrRepository pqrRepository;

//    @Override
//    public long createPqr(Pqr pqr) {
//        return 0;
//    }

    @Override
    public Collection<Pqr> getPqrs() {
        return pqrRepository.findAll();
    }

    @Override
    public Pqr getPqrById(long id) {
        if (pqrExists(id)) {
            return pqrRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Pqr getPqrByPqrString(String pqrString) {
        try {
            return pqrRepository.findByPqrStringIgnoreCase(pqrString);
        }
        catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updatePqr(long id, Pqr newPqr) {
        if (pqrExists(id)) {
            Pqr pqr = pqrRepository.findById(id).get();
            pqr.setPqrString(newPqr.getPqrString());
            pqr.setName(newPqr.getName());
            pqr.setDescription(newPqr.getDescription());
            pqr.setRatio(newPqr.getRatio());
            pqrRepository.save(pqr);
        } else {
//            throw new RecordNotFoundException();
            throw new RecordNotFoundException("Pqr", id);
        }
    }

    @Override
    public long createPqr(Pqr pqr) {
        if (pqr.getPqrString() == null)
            throw new IncompleteRecordException();
        Pqr newPqr = pqrRepository.save(pqr);
        return newPqr.getId();
    }

    @Override
    public void deletePqr(long id) {
        if (pqrExists(id)) {
            pqrRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean pqrExists(long id) {
        return pqrRepository.existsById(id);
    }


}
