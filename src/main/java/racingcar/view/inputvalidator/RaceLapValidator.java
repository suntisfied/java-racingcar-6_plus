package racingcar.view.inputvalidator;

import static racingcar.util.ValidatingUtils.isPositiveInteger;

import racingcar.view.inputform.InputValidatorForm;
import racingcar.setting.Texts;

public class RaceLapValidator extends InputValidatorForm {
    public static void checkRaceLapValidity(String input) {
        throwIllegalArgumentExceptionToInvalid(Texts.ERROR_INVALID_RACE_LAP.text,
                () -> validateRaceLap(input));
    }

    private static boolean validateRaceLap(String input) {
        return isPositiveInteger.test(input);
    }
}
