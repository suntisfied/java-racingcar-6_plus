package racingcar;

import static racingcar.DriveTrialsGenerator.generateDriveTrials;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.DriveTrials;
import racingcar.valueholder.MaxRaceLap;

public class DrivePlanMaker {

    public static DrivePlan createDrivePlan(CarNames carNames, MaxRaceLap maxRaceLap) {
        return new DrivePlan(carNames.names().stream()
                .collect(Collectors.toMap(Function.identity(), key -> new DriveTrials(generateDriveTrials(maxRaceLap)),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)));
    }
}
