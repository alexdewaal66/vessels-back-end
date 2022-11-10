package nl.alexdewaal66.novi.vessels.infrastructure;

import nl.alexdewaal66.novi.vessels.infrastructure.deletion.Deletion;
import nl.alexdewaal66.novi.vessels.infrastructure.deletion.DeletionService;
import nl.alexdewaal66.novi.vessels.infrastructure.dummy.Dummy;
import nl.alexdewaal66.novi.vessels.infrastructure.dummy.DummyRepository;
import nl.alexdewaal66.novi.vessels.infrastructure.dummy.DummyServiceImpl;
import nl.alexdewaal66.novi.vessels.payload.Mutations;
import nl.alexdewaal66.novi.vessels.utils.AuthorizationHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.TypedArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class GenericServiceImplTest {

    @Autowired
    private DummyServiceImpl dummyService;

    @MockBean
    private DummyRepository dummyRepository;

    @MockBean
    private DeletionService deletionService;

    @MockBean
    AuthorizationHelper authorizationHelper;

    @Test
    @DisplayName("getById: returns Dummy instance of particular id")
    void getById() {
        // arrange
        Timestamp twenty22 = Timestamp.valueOf("2022-01-01 00:00:00");
        Dummy dummy = new Dummy(131071L, twenty22, null, null, "testDummy");
        Mockito.when(dummyRepository.findById(131071L))
                .thenReturn(Optional.of(dummy));
        // act
        Dummy actual = dummyService.getById(131071L);
        // assert
        assertEquals(dummy, actual);
    }

    @Test
    @DisplayName("getAll: returns collection of all Dummy instances")
    void getAll() {
        // arrange
        Timestamp twenty20 = Timestamp.valueOf("2020-01-01 00:00:00");
        Timestamp twenty21 = Timestamp.valueOf("2021-01-01 00:00:00");
        Timestamp twenty22 = Timestamp.valueOf("2022-01-01 00:00:00");
        Dummy dummy20 = new Dummy(127L, twenty20, null, null, "puppet");
        Dummy dummy21 = new Dummy(8191L, twenty21, null, null, "puppet");
        Dummy dummy22 = new Dummy(131071L, twenty22, null, null, "puppet");
        List<Dummy> dummies = new ArrayList<>(List.of(dummy20, dummy21, dummy22));
        Mockito.when(dummyRepository.findAll())
                .thenReturn(dummies);
        // act
        Collection<Dummy> actual = dummyService.getAll();
        // assert
        assertEquals(dummies, actual);
    }

    @Test
    @DisplayName("getByTimestampAfter: returns Mutations instance consisting of all Dummies and all Deletions named 'dummy' both created after provided timestamp")
    void getByTimestampAfter() {
        // arrange
        Timestamp twenty20 = Timestamp.valueOf("2020-01-01 00:00:00");
        Timestamp twenty21 = Timestamp.valueOf("2021-01-01 00:00:00");
        Timestamp twenty22 = Timestamp.valueOf("2022-01-01 00:00:00");

        Deletion del21 = new Deletion(2L, "dummy", 7L, twenty21);
        Deletion del22 = new Deletion(3L, "dummy", 31L, twenty22);
        Collection<Deletion> dummyDeletions = new ArrayList<>(List.of(del21, del22));

        Dummy dummy20 = new Dummy(127L, twenty20, null, null, "Dummy-127");
        Dummy dummy21 = new Dummy(8191L, twenty21, null, null, "Dummy-8191");
        Dummy dummy22 = new Dummy(131071L, twenty22, null, null, "Dummy-131071");
        Collection<Dummy> newDummies = new ArrayList<>(List.of(dummy20, dummy21, dummy22));

        Timestamp twenty15 = Timestamp.valueOf("2015-01-01 00:00:00");

        Mockito.when(dummyRepository.findAllByTimestampAfter(twenty15))
                .thenReturn(newDummies);
        Mockito.when(deletionService.findDeletions("dummy", twenty15))
                .thenReturn(dummyDeletions);

        Mutations<Dummy> expected = new Mutations<>(newDummies, dummyDeletions);
        // act
        Mutations<Dummy> actual = dummyService.getByTimestampAfter(twenty15);
        // assert
        assertEquals(expected.getFresh(), actual.getFresh(), "fresh");
        assertEquals(expected.getDeleted(), actual.getDeleted(), "deleted");
    }

    @Test
    @DisplayName("create: returns new id and saves name of Principal as owner of Dummy instance")
    void create() {
        // arrange
        Timestamp twenty20 = Timestamp.valueOf("2020-01-01 00:00:00");
        String principalName = "HarryPotter";
        Dummy beforeCreate = new Dummy(0L, null, null, null, "puppet");
        Dummy afterSave = new Dummy( 127L, twenty20, principalName, null, "puppet");
        Mockito.when(authorizationHelper.getPrincipalName())
                .thenReturn(principalName);
        Mockito.when(dummyRepository.save(any(Dummy.class)))
                .thenReturn(afterSave);
        // act
        Long newId = dummyService.create(beforeCreate);
        // assert
        ArgumentCaptor<Dummy> argument = ArgumentCaptor.forClass(Dummy.class);
        Mockito.verify(dummyRepository).save(argument.capture());
        assertEquals(principalName, argument.getValue().getOwner());
        assertEquals(127L, newId);
    }

    static class TimestampConverter extends TypedArgumentConverter<String, Timestamp> {
        protected TimestampConverter() {
            super(String.class, Timestamp.class);
        }

        @Override
        public Timestamp convert(String source) throws ArgumentConversionException {
            try {
                return Timestamp.valueOf(source);
            } catch (IllegalArgumentException e) {
                throw new ArgumentConversionException("Cannot convert timestamp value", e);
            }
        }
    }

    @Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @ConvertWith(TimestampConverter.class)
    public @interface TimestampValue {}


    interface TestFunction {
        void run();
    }

    interface ArgumentChangingTestFunction {
        void run(Object target);
    }


    @ParameterizedTest
    @CsvSource({
            "1, 123, 2020-01-01 00:00:00, 2112-01-01 00:00:00, real-owner, old-dummy-name, new-dummy-name, principal-name, fake-owner, fake-updater, true, true, 1",
            "1, 123, 2020-01-01 00:00:00, 2112-01-01 00:00:00, real-owner, old-dummy-name, new-dummy-name, principal-name, fake-owner, fake-updater, false, true, 0",
            "1, 123, 2020-01-01 00:00:00, 2112-01-01 00:00:00, real-owner, old-dummy-name, new-dummy-name, principal-name, fake-owner, fake-updater, true, false, 0",
    })
    @DisplayName("update: IF item exists and Principle is eligible THEN " +
            "saves changed fields of item with provided id; " +
            "ignores fields 'id', 'owner' and 'updater' of provided item; " +
            "sets Principle's name as 'updater';")
    void update(Long realId, Long fakeId,
                @TimestampValue Timestamp oldTimestamp,
                @TimestampValue Timestamp fakeTimestamp,
                String realOwner, String oldDummyName, String newDummyName, String principalName, String fakeOwner, String fakeUpdater, boolean exists, boolean eligible, int timesSaved) {
        // arrange
        Dummy oldDummy = new Dummy(realId, oldTimestamp, realOwner, null, oldDummyName);
        Dummy newDummy = new Dummy(fakeId, fakeTimestamp, fakeOwner, fakeUpdater, newDummyName);
        Mockito.when(dummyRepository.existsById(realId)).thenReturn(exists);
        Mockito.when(dummyRepository.getOne(realId))
                .thenReturn(oldDummy);
        Mockito.when(authorizationHelper.isEligible(realOwner))
                .thenReturn(eligible);
        Mockito.when(authorizationHelper.getPrincipalName())
                .thenReturn(principalName);
        String scenario = exists ? "item exists, " : "item absent, " +
                (eligible ? "eligible, " : "ineligible, " +
                        "should have saved " + timesSaved + " times");
        // act
        Object response = null;
//        ArgumentChangingTestFunction testCode = (target) -> (target = dummyService.update(realId, newDummy));
        ArgumentChangingTestFunction testCode = (target) -> {
            target = dummyService.update(realId, newDummy);
        };
        String actualMessage = "";
        if (exists && eligible) {
            testCode.run(response);
        } else {
            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                testCode.run(response);
            }, " ❌ assertThrows()");
            actualMessage = exception.getMessage();
        }
        // assert
        assertEquals(!exists, actualMessage.contains("Cannot find dummy: " + realId), scenario);
        assertEquals(!eligible, actualMessage.contains("User not eligible to update dummy: " + realId), scenario);
        if (exists && eligible) {// otherwise no call to repo
            ArgumentCaptor<Dummy> captor = ArgumentCaptor.forClass(Dummy.class);
            Mockito
                    .verify(dummyRepository, Mockito.times(timesSaved).description(scenario))
                    .save(captor.capture());
            assertEquals(realOwner, captor.getValue().getOwner(), scenario);
            assertEquals(realId, captor.getValue().getId(), scenario);
            assertEquals(principalName, captor.getValue().getUpdater(), scenario);
            assertEquals(newDummyName, captor.getValue().getDummyName(), scenario);
            // todo: check response
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1, 123, 2020-01-01 00:00:00, 2112-01-01 00:00:00, real-owner, old-dummy-name, new-dummy-name, principal-name, fake-owner, fake-updater, true, true, true",
            "1, 123, 2020-01-01 00:00:00, 2112-01-01 00:00:00, real-owner, old-dummy-name, new-dummy-name, principal-name, fake-owner, fake-updater, false, true, false",
            "1, 123, 2020-01-01 00:00:00, 2112-01-01 00:00:00, real-owner, old-dummy-name, new-dummy-name, principal-name, fake-owner, fake-updater, true, false, false",
    })
    @DisplayName("update: IF item exists and Principle is eligible THEN" +
            "creates a deletion (entityName + id); " +
            "deletes item;")
    void delete(Long realId, Long fakeId,
                @TimestampValue Timestamp oldTimestamp,
                @TimestampValue Timestamp fakeTimestamp,
                String realOwner, String oldDummyName, String newDummyName, String principalName, String fakeOwner, String fakeUpdater, boolean exists, boolean eligible, boolean deleted) {
        // arrange
        Dummy oldDummy = new Dummy(realId, oldTimestamp, realOwner, null, oldDummyName);
//        Dummy newDummy = new Dummy(fakeId, fakeTimestamp, fakeOwner, fakeUpdater, newDummyName);
        Mockito.when(dummyRepository.existsById(realId)).thenReturn(exists);
        Mockito.when(dummyRepository.getOne(realId))
                .thenReturn(oldDummy);
        Mockito.when(authorizationHelper.isEligible(realOwner))
                .thenReturn(eligible);
        Mockito.when(authorizationHelper.getPrincipalName())
                .thenReturn(principalName);
        String scenario =
                (exists ? "item exists, " : "item absent, ") +
                (eligible ? "eligible, " : "ineligible, ") +
                        (deleted ? "" : "not ") + "deleted";
        // act
        TestFunction testCode = () -> {dummyService.delete(realId);};

        String actualMessage = "";
        if (exists && eligible) {
            testCode.run();
        } else {
            Exception exception = Assertions.assertThrows(Exception.class, testCode::run,
                    "assertThrows() " + scenario);
            actualMessage = exception.getMessage() + "";
        }
        // assert
        assertEquals(!exists, actualMessage.contains("Cannot find dummy: " + realId), actualMessage);
        assertEquals(!eligible, actualMessage.contains("User not eligible to delete dummy: " + realId), actualMessage);
        if (exists && eligible) {// otherwise no call to repo
            ArgumentCaptor<Long> dummyRepoCaptor = ArgumentCaptor.forClass(Long.class);
            Mockito
                    .verify(dummyRepository, Mockito.atLeastOnce().description("verify()" + scenario))
                    .deleteById(dummyRepoCaptor.capture());
            assertEquals(realId, dummyRepoCaptor.getValue());

            ArgumentCaptor<Long> deletionIdCaptor = ArgumentCaptor.forClass(Long.class);
            ArgumentCaptor<String> deletionNameCaptor = ArgumentCaptor.forClass(String.class);
            Mockito
                    .verify(deletionService, Mockito.atLeastOnce().description("verify()" + scenario))
                    .create(deletionNameCaptor.capture() ,deletionIdCaptor.capture());
            assertEquals(realId, deletionIdCaptor.getValue());
        }
    }

    @Test
    @DisplayName("exists: returns truth value on item presence using Id")
    void exists() {
        // arrange
        Long existentId = 8191L;
        Long absentId = 131071L;
        Mockito.when(dummyRepository.existsById(existentId))
                .thenReturn(true);
        Mockito.when(dummyRepository.existsById(absentId))
                .thenReturn(false);
        // act
        boolean shouldExist = dummyService.exists(existentId);
        boolean shouldNotExist = dummyService.exists(absentId);
        // assert
        assertTrue(shouldExist);
        assertFalse(shouldNotExist);
    }

    @Test
    void getAllIds() {
        // arrange
        // act
        // assert
    }

    @Test
    void getByIds() {
        // arrange
        // act
        // assert
    }

}