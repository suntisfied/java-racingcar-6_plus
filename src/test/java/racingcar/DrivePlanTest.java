package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.Settings.MAXIMUM_DRIVE_TRIAL;
import static racingcar.Settings.MINIMUM_DRIVE_TRIAL;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
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
            "3, 1, 0",
            "3, 2, 0",
            "3, 3, 0",
            "4, 1, 1",
            "4, 2, 2",
            "4, 3, 3",
    })
    void shouldBeBasedOnInput(int mockDriveTrial, int mockCurrentRaceLap, int mockDriveByRaceLap) {
        CarNames carNames = new CarNames(List.of(new CarName("alpha"), new CarName("bravo")));
        MaxRaceLap maxRaceLap = new MaxRaceLap(3);

        try (MockedStatic<Randoms> mockRandoms = Mockito.mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(MINIMUM_DRIVE_TRIAL.getNumber(), MAXIMUM_DRIVE_TRIAL.getNumber()))
                    .thenReturn(mockDriveTrial);

            DrivePlan drivePlan = new PaceMaker(carNames, maxRaceLap).createDrivePlan();
            int DriveByRaceLap = drivePlan.computeDriveByRaceLap(new CarName("alpha"), new RaceLap(mockCurrentRaceLap));
            CarNames winners = drivePlan.pickWinners();

            assertAll(
                    () -> assertEquals(mockDriveByRaceLap, DriveByRaceLap),
                    () -> assertEquals(carNames, winners),
                    () -> assertEquals(carNames, drivePlan.getCarNames()));
        }
    }
}