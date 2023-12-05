package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.Settings.MAXIMUM_DRIVE_TRIAL;
import static racingcar.Settings.MINIMUM_DRIVE_TRIAL;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Test;
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
            "3, false",
            "4, true",
    })
    void shouldBeBasedOnInput(int mockDriveTrial, boolean mockDriveOrNot) {
        CarNames carNames = new CarNames(List.of(new CarName("alpha"), new CarName("bravo"), new CarName("charlie")));
        MaxRaceLap maxRaceLap = new MaxRaceLap(5);

        try (MockedStatic<Randoms> mockRandoms = Mockito.mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(MINIMUM_DRIVE_TRIAL.getNumber(), MAXIMUM_DRIVE_TRIAL.getNumber()))
                    .thenReturn(mockDriveTrial);

            DrivePlan drivePlan = new PaceMaker(carNames, maxRaceLap).createDrivePlan();
            boolean driveOrNot = drivePlan.isDriving(new CarName("alpha"), new RaceLap(0));

            assertAll(
                    () -> assertThat(driveOrNot).isEqualTo(mockDriveOrNot),
                    () -> assertEquals(carNames, drivePlan.getCarNames()));
        }
    }
}