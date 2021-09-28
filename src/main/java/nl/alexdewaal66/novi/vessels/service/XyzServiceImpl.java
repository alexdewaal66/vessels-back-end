package nl.alexdewaal66.novi.vessels.service;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.repository.XyzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XyzServiceImpl extends GenericServiceImpl<Xyz> implements XyzService {

    @Autowired
    private XyzRepository repository;

    public XyzServiceImpl(XyzRepository repository) {
        super(repository);
    }
}

//package nl.alexdewaal66.novi.vessels.service;
//
//import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
//import nl.alexdewaal66.novi.vessels.exceptions.IncompleteRecordException;
//import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
//import nl.alexdewaal66.novi.vessels.model.ProjectId;
//import nl.alexdewaal66.novi.vessels.model.Xyz;
//import nl.alexdewaal66.novi.vessels.repository.XyzRepository;
//import nl.alexdewaal66.novi.vessels.utils.Match;
//import nl.alexdewaal66.novi.vessels.utils.Matcher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//
//@Service
////public class XyzServiceImpl implements GenericService<Xyz, XyzRepository> {
//public class XyzServiceImpl implements XyzService {
//
//    @Autowired
//    private XyzRepository xyzRepository;
//
//    @Override
//    public Collection<ProjectId> getAllIds() {
//        return xyzRepository.findAllBy();
//    }
//
//    @Override
//    public Xyz getById(Long id) {
//        if (exists(id)) {
//            return xyzRepository.findById(id).orElse(null);
//        } else {
//            throw new RecordNotFoundException("Xyz", id);
//        }
//    }
//
//    @Override
//    public List<Xyz> getByIds(List<Long> ids) {
//        return xyzRepository.findAllById(ids);
//    }
//
//    @Override
//    public Collection<Xyz> getAll() {
//        return xyzRepository.findAll();
//    }
//
//    @Override
//    public Xyz findOneByExample(Match<Xyz> match) {
//        Xyz probe = match.getProbe();
//        String mode = match.getMode();
//        Example<Xyz> example = Example.of(probe, Matcher.build(mode, Xyz.textProperties));
//        return xyzRepository.findOne(example)
//                .orElseThrow(() -> new BadRequestException("no result found"));
//    }
//
//    @Override
//    public List<Xyz> findAllByExample(Match<Xyz> match) {
//        Xyz probe = match.getProbe();
//        String mode = match.getMode();
//        Example<Xyz> example = Example.of(probe, Matcher.build(mode, Xyz.textProperties));
//        return xyzRepository.findAll(example);
//    }
//
//    @Override
//    public Long create(Xyz item) {
//        if (item.getXyzString() == null)
//            throw new IncompleteRecordException();
//        item.setId(0); // protects from overwriting existing instance
//        Xyz newItem = xyzRepository.save(item);
//        return newItem.getId();
//    }
//
//    @Override
//    public void update(Long id, Xyz newItem) {
//        if (exists(id)) {
//            newItem.setId(id);
//            xyzRepository.save(newItem);
//        } else {
//            System.out.printf("❌ RecordNotFoundException(\"Xyz\", %d)%n", id);
//            throw new RecordNotFoundException("Xyz", id);
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        if (exists(id)) {
//            xyzRepository.deleteById(id);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }
//
//    @Override
//    public boolean exists(Long id) {
//        return xyzRepository.existsById(id);
//    }
//}
