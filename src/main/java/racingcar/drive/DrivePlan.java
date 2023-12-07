package racingcar.drive;

import static racingcar.drive.DriveTrialsGenerator.generateDriveTrials;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.setting.Settings;
import racingcar.valueholder.CarName;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.DriveTrials;
import racingcar.valueholder.MaxRaceLap;
import racingcar.valueholder.RaceLap;

public class DrivePlan {
    private final Map<CarName, DriveTrials> drivePlan;

    public DrivePlan(final CarNames carNames, final MaxRaceLap maxRaceLap) {
        drivePlan = createDrivePlan(carNames, maxRaceLap);
    }

    private Map<CarName, DriveTrials> createDrivePlan(CarNames carNames, MaxRaceLap maxRaceLap) {
        return carNames.names().stream()
                .collect(Collectors.toMap(Function.identity(), key -> new DriveTrials(generateDriveTrials(maxRaceLap)),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

    public int computeDriveByRaceLap(CarName carName, RaceLap raceLap) {
        return (int) IntStream.rangeClosed(0, raceLap.number())
                .filter(currentLap -> isDriving(carName, new RaceLap(currentLap)))
                .count();
    }

    private boolean isDriving(CarName carName, RaceLap raceLap) {
        return drivePlan.get(carName).getTrial(raceLap) >= Settings.STANDARD_TO_DRIVE.getNumber();
    }

    public CarNames pickWinners() {
        var driveLog = createDriveLog();
        int maxDrive = computeMaxDrive(driveLog);

        return new CarNames(driveLog.entrySet().stream()
                .filter(entry -> entry.getValue() == maxDrive)
                .map(Map.Entry::getKey)
                .toList());
    }

    private Map<CarName, Integer> createDriveLog() {
        return drivePlan.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> computeDriveByRaceLap(entry.getKey(), new RaceLap(getMaxRaceLap().number() - 1)),
                (oldValue, newValue) -> oldValue,
                LinkedHashMap::new
        ));
    }

    private int computeMaxDrive(Map<CarName, Integer> driveLog) {
        return driveLog.values().stream().max(Integer::compareTo).orElse(0);
    }

    public MaxRaceLap getMaxRaceLap() {
        return new MaxRaceLap(drivePlan.values().stream().toList().get(0).trials().size());
    }

    public CarNames getCarNames() {
        return new CarNames(drivePlan.keySet().stream().toList());
    }
}
