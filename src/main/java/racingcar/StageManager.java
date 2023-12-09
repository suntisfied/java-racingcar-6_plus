package racingcar;

import racingcar.drive.DrivePlan;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.MaxRaceLap;
import racingcar.view.input.CarNameReader;
import racingcar.view.input.RaceLapReader;
import racingcar.view.outputformat.DriveFormatter;
import racingcar.view.outputformat.WinnerFormatter;

public class StageManager {
    public static void proceedRace() {
        CarNames carNames = CarNameReader.readCarNames();
        MaxRaceLap maxRaceLap = RaceLapReader.readRaceLap();

        DrivePlan drivePlan = new DrivePlan(DrivePlan.createDrivePlan(carNames, maxRaceLap));

        System.out.println(DriveFormatter.formatDrive(drivePlan));
        System.out.println(WinnerFormatter.formatWinners(drivePlan));
    }
}
