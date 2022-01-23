package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.generics2.GenericServiceImpl2;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.model.ZyxSummaryProjection;
import nl.alexdewaal66.novi.vessels.repository.ZyxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ZyxServiceImpl extends GenericServiceImpl2<Zyx> implements ZyxService {

    @Autowired
    private ZyxRepository zyxRepository;

    public ZyxServiceImpl(ZyxRepository repository) {
        super(ZyxSummaryProjection.class, repository);
    }


    @Override
    public Zyx getZyxByName(String name) {
        try {
            return zyxRepository.findByName(name);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }
//    @Override
//    public Collection<ZyxSummaryProjection> getSummaries() {
//        return zyxRepository.findAllBy();
//    }

}
