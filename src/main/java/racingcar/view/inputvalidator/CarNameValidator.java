package racingcar.view.inputvalidator;

import static racingcar.util.ValidatingUtils.areAllAlphabets;
import static racingcar.util.ValidatingUtils.isProperCarNameLength;
import static racingcar.util.ValidatingUtils.isUniqueOnly;
import static racingcar.util.ValidatingUtils.isUsingProperDelimiter;

import racingcar.setting.Texts;

public class CarNameValidator extends InputValidatorForm {
    public static void checkCarNameInputValidity(String input) {
        throwIllegalArgumentExceptionToInvalid(Texts.ERROR_INVALID_CAR_NAMES.getText(),
                () -> validateCarNames(input));
    }

    private static boolean validateCarNames(String input) {
        return areAllAlphabets.test(input)
                && isProperCarNameLength.test(input)
                && isUniqueOnly.test(input)
                && isUsingProperDelimiter.test(input);
    }
}
