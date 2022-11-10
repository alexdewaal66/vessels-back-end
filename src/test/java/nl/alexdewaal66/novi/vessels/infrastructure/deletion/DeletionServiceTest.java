package nl.alexdewaal66.novi.vessels.infrastructure.deletion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Deletion Service")
class DeletionServiceTest {

    @Autowired
    private DeletionService deletionService;

    @MockBean
    private DeletionRepository deletionRepositoryMock;

    @Test
    @DisplayName("findDeletions: return deletions by provided entityName and timestamp")
    void findDeletions() {
        // arrange
        Timestamp twenty22 = Timestamp.valueOf("2022-01-01 00:00:00");
        Timestamp twenty66pi = Timestamp.valueOf("2066-03-14 00:00:00");
        Deletion enduser123 = new Deletion(19L, "enduser", 123L, twenty66pi);
        List<Deletion> queryResultList = new ArrayList<>(List.of(enduser123));
        Mockito
                .when(deletionRepositoryMock.findDeletions("enduser", twenty22))
                .thenReturn(queryResultList);
        // act
        Collection<Deletion> result =
                deletionService.findDeletions("enduser", twenty22);
        // assert
        assertEquals(queryResultList, result);
    }

    @Test
    @DisplayName("create: constructed Deletion should be saved (with timestamp)")
    void create() {
        // arrange
        Deletion hull1234 =
                new Deletion(null, "hull", 1234L, null);
        // act
        deletionService.create("hull", 1234L);
        // assert
        ArgumentCaptor<Deletion> argument = ArgumentCaptor.forClass(Deletion.class);
        Mockito.verify(deletionRepositoryMock).save(argument.capture());//hull1234
        assertEquals(hull1234.getEntityName(), argument.getValue().getEntityName());
        assertEquals(hull1234.getItemId(), argument.getValue().getItemId());
    }
}
