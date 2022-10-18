package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericService;
import nl.alexdewaal66.novi.vessels.model.TestType;

public interface TestTypeService extends GenericService<TestType> {

    TestType getTestTypeByName(String nameEN, String nameNL);

}
