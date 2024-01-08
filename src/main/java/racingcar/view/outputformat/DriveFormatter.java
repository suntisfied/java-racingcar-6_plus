package racingcar.view.outputformat;

import static racingcar.util.ConvertingUtils.convertNumberToGraphic;
import static racingcar.util.TextUtils.LINE_BREAK;
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

        return LINE_BREAK
                + Texts.HEAD_RESULT.getText()
                + LINE_BREAK
                + removeLastBlank(IntStream.range(0, maxRaceLap.number())
                .mapToObj(currentRaceLap ->
                        formatDriveByRaceLap(drivePlan, new RaceLap(currentRaceLap)) + LINE_BREAK)
                .collect(Collectors.joining()));
    }

    private static String formatDriveByRaceLap(DrivePlan drivePlan, RaceLap raceLap) {
        CarNames carNames = drivePlan.getCarNames();

        return carNames.names().stream()
                .map(carName -> {
                    String drive = convertNumberToGraphic(drivePlan.computeDriveByRaceLap(carName, raceLap));
                    return String.format(Texts.BODY_RESULT_FORMAT.getText(), carName.name(), drive) + LINE_BREAK;
                })
                .collect(Collectors.joining());
    }
}
