package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.Settings.MAXIMUM_DRIVE_TRIAL;
import static racingcar.Settings.MINIMUM_DRIVE_TRIAL;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.valueholder.CarName;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.DriveTrials;
import racingcar.valueholder.MaxRaceLap;

public class PaceMaker {
    private final List<CarName> carNames;
    private final int maxRaceLap;

    public PaceMaker(final CarNames carNames, final MaxRaceLap maxRaceLap) {
        this.carNames = carNames.names();
        this.maxRaceLap = maxRaceLap.number();
    }

    public DrivePlan createDrivePlan() {
        return new DrivePlan(carNames.stream()
                .collect(Collectors.toMap(Function.identity(), key -> new DriveTrials(generateDriveTrials()),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)));
    }

    private List<Integer> generateDriveTrials() {
        return IntStream.range(0, maxRaceLap)
                .mapToObj(i -> pickNumberInRange(MINIMUM_DRIVE_TRIAL.getNumber(), MAXIMUM_DRIVE_TRIAL.getNumber()))
                .toList();
    }
}
