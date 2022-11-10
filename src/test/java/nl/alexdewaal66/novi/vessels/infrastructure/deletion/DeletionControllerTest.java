package nl.alexdewaal66.novi.vessels.infrastructure.deletion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeletionControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    DeletionService deletionService;

    @Test
    @DisplayName("Deletions: endpoint Get Deletions")
    void getDeletions() throws Exception {
        // arrange
        Timestamp twenty22 = Timestamp.valueOf("2022-01-01 00:00:00");
        long twenty22millis = twenty22.getTime();
        Timestamp twenty66pi = Timestamp.valueOf("2066-03-14 00:00:00");
        Deletion enduser123 = new Deletion(19L, "enduser", 123L, twenty66pi);
        List<Deletion> queryResultList = new ArrayList<>(List.of(enduser123));

        given(deletionService.findDeletions("enduser", twenty22))
                .willReturn(queryResultList);
        // act & assert
        mvc.perform(get("/deletions")
                        .param("type", "enduser")
                        .param("time", twenty22millis + "")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].itemId", is((int) 123L)));
    }
}
