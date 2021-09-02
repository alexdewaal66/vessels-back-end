package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.VesselType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface VesselTypeRepository extends JpaRepository<VesselType, Long> {
    VesselType findByNameENContainsOrNameNLContains(String nameEN, String nameNL);

    @Query(value = "SELECT v.id FROM vessel_type v", nativeQuery = true)
    Collection<Long> getAllIds();

}
