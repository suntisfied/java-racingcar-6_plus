package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.Settings.MAXIMUM_DRIVE_TRIAL;
import static racingcar.Settings.MINIMUM_DRIVE_TRIAL;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.valueholder.CarName;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.DriveTrials;
import racingcar.valueholder.RaceLap;

public class PaceMaker {
    private final List<String> carNames;
    private final int raceLap;

    public PaceMaker(final CarNames carNames, final RaceLap raceLap) {
        this.carNames = carNames.names();
        this.raceLap = raceLap.number();
    }

    public Map<CarName, DriveTrials> createDriveLog() {
        return carNames.stream()
                .collect(Collectors.toMap(CarName::new, key -> new DriveTrials(generateDriveTrials()),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

    public List<Integer> generateDriveTrials() {
        return IntStream.range(0, raceLap)
                .mapToObj(i -> pickNumberInRange(MINIMUM_DRIVE_TRIAL.getNumber(), MAXIMUM_DRIVE_TRIAL.getNumber()))
                .toList();
    }
}
