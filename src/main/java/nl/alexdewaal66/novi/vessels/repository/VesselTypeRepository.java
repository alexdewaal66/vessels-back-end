package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.VesselType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VesselTypeRepository extends JpaRepository<VesselType, Long> {
    VesselType findByNameEnContainsOrNameNlContains(String nameEn, String nameNl);
}
