package racingcar.input;

import racingcar.inputform.ConsoleInputForm;
import racingcar.setting.Texts;
import validator.CarNameValidator;

public class CarNameReader extends ConsoleInputForm {
    public static String readCarNames() {
        return getInputUntilCorrect(() -> System.out.println(Texts.INSTRUCTION_INPUT_CAR_NAMES.getText()),
                CarNameValidator::checkCarNameInputValidity);
    }
}
