package nl.alexdewaal66.novi.vessels.infrastructure.deletion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest()
@ActiveProfiles("test")
@DisplayName("DeletionRepository")
class DeletionRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DeletionRepository deletionRepository;

    @Nested
    @DisplayName("FindDeletions: return collection of items of provided entity name deleted after provided moment")
    class FindDeletions {

        @Test
        @DisplayName("check access to the H2 in-memory database")
        void h2access() {
            assertNotNull(dataSource);
            assertNotNull(jdbcTemplate);
        }

        @Test
        @DisplayName("findDeletions: result has 4 deletions with entityName 'hull'")
        void findHullDeletions() {
            // arrange
            // data in H2 is inserted in resources.test_data.deletion.sql
            Timestamp fourDecadesAgo = Timestamp.valueOf("1983-01-01 00:00:00");
            // act
            Collection<Deletion> hullDeletions =
                    deletionRepository.findDeletions("hull", fourDecadesAgo);
            // assert
            assertEquals(4, hullDeletions.size());
        }

        @Test
        @DisplayName("findDeletions: result has 2 deletions with entityName 'xyz'")
        void findXyzDeletions() {
            // arrange
            // data in H2 is inserted in resources.test_data.deletion.sql
            Timestamp twoDecadesAgo = Timestamp.valueOf("2003-01-01 00:00:00");
            // act
            Collection<Deletion> xyzDeletions =
                    deletionRepository.findDeletions("xyz", twoDecadesAgo);
            // assert
            assertEquals(1, xyzDeletions.size());
        }

        @Test
        @DisplayName("findDeletions: result has 0 deletions with entityName 'vessel'")
        void findVesselDeletions() {
            // arrange
            // data in H2 is inserted in resources.test_data.deletion.sql
            Timestamp fourDecadesAgo = Timestamp.valueOf("1983-01-01 00:00:00");
            // act
            Collection<Deletion> vesselDeletions =
                    deletionRepository.findDeletions("vessel", fourDecadesAgo);
            // assert
            assertEquals(0, vesselDeletions.size());
        }

    }

}

//// *** insert programmatically ***
//        Timestamp jan_02_2022 = new Timestamp(1641078000000);
//        Timestamp april_05_2022 = new Timestamp(1649116800000);
//        Deletion deletion = new Deletion();
//        deletion.setEntityName("hull");
//        deletion.setItemId(17L);
//        deletion.setTimestamp(april05);
//        entityManager.persist(deletion);
//        entityManager.flush();

//        Collection<Deletion> result1 =
//                deletionRepository.findDeletions("hull", jan_02_2022);
//        Deletion soleItem = (Deletion) result1.toArray()[0];

//        assertEquals(1, result1.size());
//        assertEquals("hull", soleItem.getEntityName());
//        assertEquals(17, soleItem.getItemId());
