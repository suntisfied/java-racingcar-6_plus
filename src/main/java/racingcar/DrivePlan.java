package racingcar;

import java.util.Map;
import racingcar.valueholder.CarName;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.DriveTrials;
import racingcar.valueholder.RaceLap;

public class DrivePlan {
    private final Map<CarName, DriveTrials> drivePlan;

    public DrivePlan(final Map<CarName, DriveTrials> drivePlan) {
        this.drivePlan = drivePlan;
    }

    public CarNames getCarNames() {
        return new CarNames(drivePlan.keySet().stream().toList());
    }

    public boolean isDriving(CarName carName, RaceLap raceLap) {
        return drivePlan.get(carName).getTrial(raceLap) >= Settings.STANDARD_TO_DRIVE.getNumber();
    }
}
