package racingcar.drive;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.valueholder.CarName;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.MaxRaceLap;
import racingcar.valueholder.RaceLap;

class DrivePlanTest {
    @ParameterizedTest
    @CsvSource({
            "'3,4,5', 0, 0",
            "'3,4,5', 1, 1",
            "'3,4,5', 2, 2",
    })
    void shouldBeBasedOnInput(String mockDriveTrialsString, int mockCurrentRaceLap, int mockDriveByRaceLap) {
        CarNames carNames = new CarNames(List.of(new CarName("alpha"), new CarName("bravo")));
        MaxRaceLap maxRaceLap = new MaxRaceLap(3);
        List<Integer> mockDriveTrials = stringToIntegerList(mockDriveTrialsString);

        try (MockedStatic<DriveTrialsGenerator> mockDriveTrialsGenerator = Mockito.mockStatic(DriveTrialsGenerator.class)) {
            mockDriveTrialsGenerator.when(() -> DriveTrialsGenerator.generateDriveTrials(maxRaceLap))
                    .thenReturn(mockDriveTrials);

            DrivePlan drivePlan = new DrivePlan(carNames, maxRaceLap);
            int DriveByRaceLap = drivePlan.computeDriveByRaceLap(new CarName("alpha"), new RaceLap(mockCurrentRaceLap));
            CarNames winners = drivePlan.pickWinners();

            assertAll(
                    () -> assertEquals(mockDriveByRaceLap, DriveByRaceLap),
                    () -> assertEquals(carNames, winners),
                    () -> assertEquals(carNames, drivePlan.getCarNames()));
        }
    }

    private List<Integer> stringToIntegerList(String listInString) {
        return Stream.of(listInString.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}