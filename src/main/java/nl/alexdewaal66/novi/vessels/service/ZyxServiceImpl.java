package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.repository.ZyxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZyxServiceImpl extends GenericServiceImpl<Zyx> implements ZyxService {

    @Autowired
    private ZyxRepository zyxRepository;

    public ZyxServiceImpl(ZyxRepository repository) {
        super(repository, "Zyx"); }


    @Override
    public Zyx getZyxByName(String name) {
        try {
            return zyxRepository.findByName(name);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }
}
