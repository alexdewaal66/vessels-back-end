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

    @Override
    public Collection<Xyz> getXyzs() {
        return xyzRepository.findAll();
    }

    @Override
    public Xyz getXyzById(long id) {
        if (xyzExists(id)) {
            return xyzRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException("Xyz", id);
        }
    }

    @Override
    public Xyz getXyzByXyzString(String xyzString) {
        try {
            return xyzRepository.findByXyzStringIgnoreCase(xyzString);
        } catch (Exception e) {
            throw new RecordNotFoundException();
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
    public void updateXyz(long id, Xyz newXyz) {
        if (xyzExists(id)) {
            newXyz.setId(id);
            xyzRepository.save(newXyz);
        } else {
            System.out.printf("❌ RecordNotFoundException(\"Xyz\", %d)%n", id);
            throw new RecordNotFoundException("Xyz", id);
        }
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
