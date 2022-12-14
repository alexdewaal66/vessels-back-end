package nl.alexdewaal66.novi.vessels.infrastructure;

import nl.alexdewaal66.novi.vessels.infrastructure.dummy.Dummy;
import nl.alexdewaal66.novi.vessels.infrastructure.dummy.DummyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GenericControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    DummyServiceImpl dummyService;

    @Test
    void getById() throws Exception {
        // arrange
        Timestamp twenty22 = Timestamp.valueOf("2022-01-01 00:00:00");
        long twenty22millis = twenty22.getTime();
        Dummy dummy = new Dummy(12345L, twenty22, "OwnerName", null, "testDummy");
        given(dummyService.getById(12345L)).willReturn(dummy);
        // act & assert
        mvc.perform(get("/dummies/{id}", 12345)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is((int) 12345L)))
                .andExpect(jsonPath("$.timestamp", is(twenty22millis)))
                .andExpect(jsonPath("$.owner", is("OwnerName")));
    }

    @Test
    void getAll() throws Exception {
        // arrange
        Timestamp twenty20 = Timestamp.valueOf("2020-01-01 00:00:00");
        Timestamp twenty21 = Timestamp.valueOf("2021-01-01 00:00:00");
        Timestamp twenty22 = Timestamp.valueOf("2022-01-01 00:00:00");

        Dummy dummy20 = new Dummy(127L, twenty20, null, null, "Dummy-127");
        Dummy dummy21 = new Dummy(8191L, twenty21, null, null, "Dummy-8191");
        Dummy dummy22 = new Dummy(131071L, twenty22, null, null, "Dummy-131071");
        Collection<Dummy> allDummies = new ArrayList<>(List.of(dummy20, dummy21, dummy22));
        given(dummyService.getAll())
                .willReturn(allDummies);
        // act & assert
        mvc.perform(get("/dummies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is((int) 127L)))
                .andExpect(jsonPath("$[1].id", is((int) 8191L)))
                .andExpect(jsonPath("$[2].id", is((int) 131071L)));
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteXyz() {
    }

    @Test
    void getByTimestampAfter() {
    }
}
