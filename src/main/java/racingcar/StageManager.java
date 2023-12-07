package racingcar;

import static racingcar.util.ConvertingUtils.convertStringToCarNames;
import static racingcar.util.ConvertingUtils.convertStringToMaxRaceLap;

import racingcar.drive.DrivePlan;
import racingcar.drive.DrivePlanMaker;
import racingcar.input.CarNameReader;
import racingcar.input.RaceLapReader;
import racingcar.textformat.DriveFormatter;
import racingcar.textformat.WinnerFormatter;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.MaxRaceLap;

public class StageManager {
    public static void proceedRace() {
        CarNames carNames = convertStringToCarNames(CarNameReader.readCarNames());
        MaxRaceLap maxRaceLap = convertStringToMaxRaceLap(RaceLapReader.readRaceLap());

        DrivePlan drivePlan = DrivePlanMaker.createDrivePlan(carNames, maxRaceLap);

        System.out.println(DriveFormatter.formatDrive(drivePlan));
        System.out.println(WinnerFormatter.formatWinners(drivePlan));
    }
}
