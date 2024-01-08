package racingcar.view.input;

import racingcar.setting.Texts;
import racingcar.util.ConvertingUtils;
import racingcar.valueholder.CarNames;

public class CarNameReader extends ConsoleInputForm {
    public static CarNames readCarNames() {
        return getInputUntilCorrect(() -> System.out.println(Texts.INSTRUCTION_INPUT_CAR_NAMES.getText()),
                ConvertingUtils::convertStringToCarNames);
    }
}
