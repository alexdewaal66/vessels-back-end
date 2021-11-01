package nl.alexdewaal66.novi.vessels.repository;

//import nl.alexdewaal66.novi.vessels.repository.GenericRepositoryCustom;
import nl.alexdewaal66.novi.vessels.model.VesselType;

public interface VesselTypeRepository
        extends GenericRepository<VesselType>
//        , GenericRepositoryCustom<VesselType>
{

    VesselType findByNameENContainsOrNameNLContains(String nameEN, String nameNL);

}
