package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubdivisionServiceImpl extends GenericServiceImpl<Subdivision> implements SubdivisionService {

    @Autowired
    private SubdivisionRepository subdivisionRepository;
    public SubdivisionServiceImpl(SubdivisionRepository repository) {
        super(repository);
    }

    public Subdivision findSubdivision(String alpha2Code, String subdivisionCode) {
        try {
            return subdivisionRepository.findByAlpha2CodeAndSubdivisionCode(alpha2Code, subdivisionCode);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }
}
