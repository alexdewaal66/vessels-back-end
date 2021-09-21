package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Xyz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.alexdewaal66.novi.vessels.exceptions.IncompleteRecordException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.repository.SubdivisionRepository;

import java.util.Collection;
import java.util.List;

@Service
public class SubdivisionServiceImpl implements SubdivisionService {

    @Autowired
    private SubdivisionRepository subdivisionRepository;

    @Override
    public Collection<Long> getAllIds() {
        return subdivisionRepository.getAllIds();
    }

    @Override
    public Collection<Subdivision> getSubdivisions() {
        return subdivisionRepository.findAll();
    }

    @Override
    public List<Subdivision> getByIds(List<Long> ids) {
        return subdivisionRepository.findAllById(ids);
    }



    @Override
    public Subdivision getSubdivisionById(long id) {
        if (subdivisionExists(id)) {
            return subdivisionRepository.findById(id).orElse(null);
        } else {
            System.out.println("❌ SubdivisionServiceImpl.getSubdivisionById(long id) \n\t Record with id=" + id + " doesn't exist.");
            throw new RecordNotFoundException("Subdivision", id);
        }
    }

//    @Override
    public Subdivision findSubdivision(String alpha2Code, String subdivisionCode) {
        try {
            return subdivisionRepository.findByAlpha2CodeAndSubdivisionCode(alpha2Code, subdivisionCode);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean subdivisionExists(long id) {
        return subdivisionRepository.existsById(id);
    }
}
