package nl.alexdewaal66.novi.vessels.repository;

//import nl.alexdewaal66.novi.vessels.generics.GenericRepositoryCustom;
import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.VesselType;

public interface VesselTypeRepository
        extends GenericRepository<VesselType>
//        , GenericRepositoryCustom<VesselType>
{

    VesselType findByNameENContainsOrNameNLContains(String nameEN, String nameNL);

}
