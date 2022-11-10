package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.repository.SubdivisionRepository;
import org.springframework.stereotype.Service;


@Service
public class SubdivisionServiceImpl extends GenericServiceImpl<Subdivision> implements SubdivisionService {

    private final SubdivisionRepository subdivisionRepository;
    public SubdivisionServiceImpl(SubdivisionRepository repository, SubdivisionRepository subdivisionRepository) {
        super(repository, "Subdivision");
        this.subdivisionRepository = subdivisionRepository;
    }

    public Subdivision findSubdivision(String alpha2Code, String subdivisionCode) {
        try {
            return subdivisionRepository.findByAlpha2CodeAndSubdivisionCode(alpha2Code, subdivisionCode);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }
}
