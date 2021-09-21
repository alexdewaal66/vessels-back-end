package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.IncompleteRecordException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.repository.ZyxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ZyxServiceImpl implements ZyxService {

    @Autowired
    private ZyxRepository zyxRepository;

    @Override
    public Collection<Long> getAllIds() {
        return zyxRepository.getAllIds();
    }

    @Override
    public Collection<Zyx> getZyxs() {
        return zyxRepository.findAll();
    }

    @Override
    public List<Zyx> getByIds(List<Long> ids) {
        return zyxRepository.findAllById(ids);
    }

    @Override
    public Zyx getZyxById(long id) {
        if (zyxExists(id)) {
            return zyxRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException("Zyx", id);
        }
    }

    @Override
    public Zyx getZyxByName(String name) {
        try {
            return zyxRepository.findByName(name);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long createZyx(Zyx zyx) {
        zyx.setId(0L);
        Zyx newZyx = zyxRepository.save(zyx);
        return newZyx.getId();
    }

    @Override
    public void updateZyx(long id, Zyx newZyx) {
        if (zyxExists(id)) {
            newZyx.setId(id);
            zyxRepository.save(newZyx);
        } else {
            System.out.printf("❌ RecordNotFoundException(\"Zyx\", %d)%n", id);
            throw new RecordNotFoundException("Zyx", id);
        }
    }

    @Override
    public void deleteZyx(long id) {
        if (zyxExists(id)) {
            zyxRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean zyxExists(long id) {
        return zyxRepository.existsById(id);
    }
}
