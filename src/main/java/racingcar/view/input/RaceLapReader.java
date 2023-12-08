package racingcar.view.input;

import racingcar.view.inputform.ConsoleInputForm;
import racingcar.setting.Texts;
import racingcar.view.validator.RaceLapValidator;

public class RaceLapReader extends ConsoleInputForm {
    public static String readRaceLap() {
        return getInputUntilCorrect(() -> System.out.println(Texts.INSTRUCTION_INPUT_RACE_LAP.getText()),
                RaceLapValidator::checkRaceLapValidity);
    }
}
