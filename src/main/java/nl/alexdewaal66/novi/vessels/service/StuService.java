package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Stu;

import java.util.Collection;

public interface StuService {

    long createStu(Stu stu);

    Collection<Stu> getStus();
    Stu getStuById(long id);
    Stu getStuByStuString(String stuString);

    void updateStu(long id, Stu stu);

    void deleteStu(long id);

    boolean stuExists(long id);

}
