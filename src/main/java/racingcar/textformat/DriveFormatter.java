package racingcar.textformat;

import static racingcar.util.ConvertingUtils.convertNumberToGraphic;
import static racingcar.util.TextUtils.removeLastBlank;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.drive.DrivePlan;
import racingcar.setting.Texts;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.MaxRaceLap;
import racingcar.valueholder.RaceLap;

public class DriveFormatter {
    public static String formatDrive(DrivePlan drivePlan) {
        MaxRaceLap maxRaceLap = drivePlan.getMaxRaceLap();

        return System.lineSeparator()
                + Texts.HEAD_RESULT.getText()
                + System.lineSeparator()
                + removeLastBlank(IntStream.range(0, maxRaceLap.number())
                .mapToObj(currentRaceLap ->
                        formatDriveByRaceLap(drivePlan, new RaceLap(currentRaceLap)) + System.lineSeparator())
                .collect(Collectors.joining()));
    }

    private static String formatDriveByRaceLap(DrivePlan drivePlan, RaceLap raceLap) {
        CarNames carNames = drivePlan.getCarNames();

        return carNames.names().stream()
                .map(carName -> {
                    String drive = convertNumberToGraphic(drivePlan.computeDriveByRaceLap(carName, raceLap));
                    return carName.name() + " : " + drive + System.lineSeparator();
                })
                .collect(Collectors.joining());
    }
}
