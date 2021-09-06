package nl.alexdewaal66.novi.vessels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.alexdewaal66.novi.vessels.exceptions.IncompleteRecordException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.UNLocode;
import nl.alexdewaal66.novi.vessels.repository.UNLocodeRepository;

import java.util.Collection;
import java.util.List;

@Service
public class UNLocodeServiceImpl implements UNLocodeService{

    @Autowired
    private UNLocodeRepository unLocodeRepository;

    @Override
    public Collection<Long> getAllIds() {
        return unLocodeRepository.getAllIds();
    }

    @Override
    public Collection<UNLocode> getUNLocodes() {
        return unLocodeRepository.findAll();
    }

    @Override
    public List<UNLocode> getByIds(List<Long> ids) {
        return unLocodeRepository.findAllById(ids);
    }

    @Override
    public UNLocode getUNLocodeById(long id) {
        if (unLocodeExists(id)) {
            return unLocodeRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException("UNLocode", id);
        }
    }

    @Override
    public UNLocode getUNLocodeByCodes(String alpha2Code, String locationCode) {
        try {
            return unLocodeRepository
                    .findByAlpha2CodeAndLocationCode(alpha2Code, locationCode);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public UNLocode getUNLocodeByName(String name) {
        try {
            return unLocodeRepository
                    .findByNameDiacriticsContainsOrNameWoDiacriticsContains(name, name);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean unLocodeExists(long id) {
        return unLocodeRepository.existsById(id);
    }

}
