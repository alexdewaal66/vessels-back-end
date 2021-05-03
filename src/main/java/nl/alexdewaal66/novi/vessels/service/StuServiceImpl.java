package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.IncompleteRecordException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.Stu;
import nl.alexdewaal66.novi.vessels.repository.StuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuRepository stuRepository;

//    @Override
//    public long createStu(Stu stu) {
//        return 0;
//    }

    @Override
    public Collection<Stu> getStus() {
        return stuRepository.findAll();
    }

    @Override
    public Stu getStuById(long id) {
        if (stuExists(id)) {
            return stuRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Stu getStuByStuString(String stuString) {
        try {
            return stuRepository.findByStuStringIgnoreCase(stuString);
        }
        catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateStu(long id, Stu newStu) {
        if (stuExists(id)) {
            Stu stu = stuRepository.findById(id).get();
            stu.setStuString(newStu.getStuString());
            stu.setName(newStu.getName());
            stu.setDescription(newStu.getDescription());
            stu.setRatio(newStu.getRatio());
            stuRepository.save(stu);
        } else {
//            throw new RecordNotFoundException();
            throw new RecordNotFoundException("Stu", id);
        }
    }

    @Override
    public long createStu(Stu stu) {
        if (stu.getStuString() == null)
            throw new IncompleteRecordException();
        Stu newStu = stuRepository.save(stu);
        return newStu.getId();
    }

    @Override
    public void deleteStu(long id) {
        if (stuExists(id)) {
            stuRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean stuExists(long id) {
        return stuRepository.existsById(id);
    }


}
