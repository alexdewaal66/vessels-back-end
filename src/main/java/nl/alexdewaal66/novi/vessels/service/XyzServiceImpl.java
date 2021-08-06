package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.IncompleteRecordException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.repository.XyzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class XyzServiceImpl implements XyzService {

    @Autowired
    private XyzRepository xyzRepository;

//    @Override
//    public long createXyz(Xyz xyz) {
//        return 0;
//    }

    @Override
    public Collection<Xyz> getXyzs() {
        return xyzRepository.findAll();
    }

    @Override
    public Xyz getXyzById(long id) {
        if (xyzExists(id)) {
            return xyzRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Xyz getXyzByXyzString(String xyzString) {
        try {
            return xyzRepository.findByXyzStringIgnoreCase(xyzString);
        }
        catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateXyz(long id, Xyz newXyz) {
        if (xyzExists(id)) {
            Xyz xyz = xyzRepository.findById(id).get();
            xyz.setXyzString(newXyz.getXyzString());
            xyz.setName(newXyz.getName());
            xyz.setDescription(newXyz.getDescription());
            xyz.setRatio(newXyz.getRatio());
            xyzRepository.save(xyz);
        } else {
//            throw new RecordNotFoundException();
            throw new RecordNotFoundException("Xyz", id);
        }
    }

    @Override
    public long createXyz(Xyz xyz) {
        if (xyz.getXyzString() == null)
            throw new IncompleteRecordException();
        xyz.setId(0); // protects from overwriting existing instance
        Xyz newXyz = xyzRepository.save(xyz);
        return newXyz.getId();
    }

    @Override
    public void deleteXyz(long id) {
        if (xyzExists(id)) {
            xyzRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean xyzExists(long id) {
        return xyzRepository.existsById(id);
    }


}
