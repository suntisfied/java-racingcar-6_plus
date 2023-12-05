package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.valueholder.CarName;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.DriveTrials;
import racingcar.valueholder.RaceLap;

class PaceMakerTest {
    @Test
    void shouldCreateMapBasedOnInput() {
        CarNames carNames = new CarNames(List.of("alpha", "bravo", "charlie"));
        RaceLap raceLap = new RaceLap(5);

        PaceMaker paceMaker = new PaceMaker(carNames, raceLap);
        Map<CarName, DriveTrials> driveLog = paceMaker.createDriveLog();

        Set<String> rawDriveLogKeys = driveLog.keySet().stream().map(CarName::name).collect(Collectors.toSet());
        List<Integer> rawDriveLogValues = driveLog.values().stream()
                .map(DriveTrials::trials).flatMap(List::stream).toList();

        assertAll(
                () -> assertThat(rawDriveLogKeys).containsAll(carNames.names()),
                () -> assertEquals(rawDriveLogValues.size(), carNames.names().size() * raceLap.number())
        );
    }
}