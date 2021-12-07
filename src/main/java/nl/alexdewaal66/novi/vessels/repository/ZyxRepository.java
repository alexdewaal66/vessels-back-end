package nl.alexdewaal66.novi.vessels.repository;
import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Zyx;

public interface ZyxRepository extends GenericRepository<Zyx> {
    Zyx findByName(String name);

}
