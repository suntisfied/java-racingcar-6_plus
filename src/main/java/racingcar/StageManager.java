package racingcar;

import static racingcar.util.ConvertingUtils.convertStringToCarNames;
import static racingcar.util.ConvertingUtils.convertStringToMaxRaceLap;

import racingcar.drive.DrivePlan;
import racingcar.view.input.CarNameReader;
import racingcar.view.input.RaceLapReader;
import racingcar.view.textformat.DriveFormatter;
import racingcar.view.textformat.WinnerFormatter;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.MaxRaceLap;

public class StageManager {
    public static void proceedRace() {
        CarNames carNames = convertStringToCarNames(CarNameReader.readCarNames());
        MaxRaceLap maxRaceLap = convertStringToMaxRaceLap(RaceLapReader.readRaceLap());

        DrivePlan drivePlan = new DrivePlan(DrivePlan.createDrivePlan(carNames, maxRaceLap));

        System.out.println(DriveFormatter.formatDrive(drivePlan));
        System.out.println(WinnerFormatter.formatWinners(drivePlan));
    }
}
