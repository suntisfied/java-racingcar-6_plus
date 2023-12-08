package racingcar.view.input;

import racingcar.view.inputform.ConsoleInputForm;
import racingcar.setting.Texts;
import racingcar.view.inputvalidator.CarNameValidator;

public class CarNameReader extends ConsoleInputForm {
    public static String readCarNames() {
        return getInputUntilCorrect(() -> System.out.println(Texts.INSTRUCTION_INPUT_CAR_NAMES.getText()),
                CarNameValidator::checkCarNameInputValidity);
    }
}
