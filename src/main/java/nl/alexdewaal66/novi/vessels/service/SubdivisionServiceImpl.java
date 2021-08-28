package nl.alexdewaal66.novi.vessels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.alexdewaal66.novi.vessels.exceptions.IncompleteRecordException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.repository.SubdivisionRepository;

import java.util.Collection;

@Service
public class SubdivisionServiceImpl implements SubdivisionService {

    @Autowired
    private SubdivisionRepository subdivisionRepository;

    @Override
    public Collection<Subdivision> getSubdivisions() {
        return subdivisionRepository.findAll();
    }

    @Override
    public Subdivision getSubdivisionById(long id) {
        if (subdivisionExists(id)) {
            return subdivisionRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException("Subdivision", id);
        }
    }

    @Override
    public Subdivision getSubdivisionByCodes(String alpha2Code, String code) {
        try {
            return subdivisionRepository.findByAlpha2CodeAndCode(alpha2Code, code);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean subdivisionExists(long id) {
        return false;
    }
}
