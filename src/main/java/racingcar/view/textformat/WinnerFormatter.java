package racingcar.view.textformat;

import java.util.stream.Collectors;
import racingcar.drive.DrivePlan;
import racingcar.setting.Texts;
import racingcar.valueholder.CarName;

public class WinnerFormatter {
    public static String formatWinners(DrivePlan drivePlan) {
        return Texts.HEAD_WINNER.getText()
                + drivePlan.pickWinners().names().stream()
                .map(CarName::name)
                .collect(Collectors.joining(", "));
    }
}
