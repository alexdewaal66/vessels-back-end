package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.UNLocode;
import nl.alexdewaal66.novi.vessels.repository.UNLocodeRepository;
import org.springframework.stereotype.Service;

@Service
public class UNLocodeServiceImpl
        extends GenericServiceImpl<UNLocode>
        implements UNLocodeService{

    private final UNLocodeRepository unLocodeRepository;

    public UNLocodeServiceImpl(UNLocodeRepository repository, UNLocodeRepository unLocodeRepository) {
        super(repository, "UNLocode");
        this.unLocodeRepository = unLocodeRepository;
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
}
