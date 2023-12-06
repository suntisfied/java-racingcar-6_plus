package racingcar.input;

import racingcar.inputform.ConsoleInputForm;
import racingcar.setting.Texts;
import validator.RaceLapValidator;

public class RaceLapReader extends ConsoleInputForm {
    public static String readRaceLap() {
        return getInputUntilCorrect(() -> System.out.println(Texts.INSTRUCTION_INPUT_RACE_LAP.getText()),
                RaceLapValidator::checkRaceLapValidity);
    }
}
