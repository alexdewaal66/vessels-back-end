package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.ProjectId;
import nl.alexdewaal66.novi.vessels.utils.Match;
import nl.alexdewaal66.novi.vessels.utils.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.repository.SubdivisionRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SubdivisionServiceImpl implements SubdivisionService {

    @Autowired
    private SubdivisionRepository subdivisionRepository;

    @Override
    public Collection<ProjectId> getAllIds() {
        return subdivisionRepository.findAllBy();
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

    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--
    List<String> textProperties = Arrays.asList("name");

    @Override
    public Optional<Subdivision> findSubdivisionByExample(Match<Subdivision> match) {
        Subdivision probe = match.getProbe();
        String mode = match.getMode();
        Example<Subdivision> example = Example.of(probe, Matcher.build(mode, textProperties));
        return subdivisionRepository.findOne(example);
    }

    @Override
    public List<Subdivision> findSubdivisionsByExample(Match<Subdivision> match) {
        Subdivision probe = match.getProbe();
        String mode = match.getMode();
        Example<Subdivision> example = Example.of(probe, Matcher.build(mode, textProperties));
        return subdivisionRepository.findAll(example);
    }
    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

    @Override
    public boolean subdivisionExists(long id) {
        return subdivisionRepository.existsById(id);
    }

}
