package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.TestType;
import nl.alexdewaal66.novi.vessels.repository.TestTypeRepository;
import nl.alexdewaal66.novi.vessels.utils.AuthorizationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTypeServiceImpl
        extends GenericServiceImpl<TestType>
        implements TestTypeService{

    public TestTypeServiceImpl(TestTypeRepository repository) {
        super(repository, "TestType");
    }

    @Autowired
    private TestTypeRepository TestTypeRepository;

    @Autowired
    private AuthorizationHelper authorizationHelper;


    @Override
    public TestType getTestTypeByName(String nameEN, String nameNL) {
        try {
            return TestTypeRepository.findByNameENContainsOrNameNLContains(nameEN, nameNL);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Long create(TestType item) {
        Long superTypeId = item.getSuperType().getId();
        TestType superType = repository.getOne(superTypeId);
        item.setSuperType(superType);
        return super.create(item);
    }

    @Override
    public Object update(Long id, TestType newItem) {
        if (id != 1L) {
            return super.update(id, newItem);
        } else {
//            logv("TestTypeServiceImpl.java » update() REJECTED", "id=" + id);
            throw new BadRequestException("not even the Admin can update TestType record #1");
        }
    }

//    @Override
    public void delete(Long id, TestType newItem) {
        if (id != 1L) {
            super.delete(id);
        } else {
//            logv("TestTypeServiceImpl.java » update() REJECTED", "id=" + id);
            throw new BadRequestException("not even the Admin can delete TestType record #1");
        }
    }

}
