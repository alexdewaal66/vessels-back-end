package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Country2;
import nl.alexdewaal66.novi.vessels.repository.Country2Repository;
import nl.alexdewaal66.novi.vessels.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class Country2ServiceImpl extends GenericServiceImpl<Country2>  {

    public Country2ServiceImpl(Country2Repository repository) {
        super(repository);
    }
}
