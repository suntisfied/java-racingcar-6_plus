package validator;

import static racingcar.util.ConvertingUtils.convertStringToList;
import static racingcar.util.ValidatingUtils.areAllAlphabets;

import java.util.List;
import racingcar.inputform.InputValidatorForm;
import racingcar.setting.Texts;

public class CarNameValidator extends InputValidatorForm {
    public static void checkCarNameInputValidity(String input) {
        throwIllegalArgumentExceptionToInvalid(Texts.ERROR_INVALID_CAR_NAMES.getText(),
                () -> validateCarNames(input));
    }

    private static boolean validateCarNames(String input) {
        List<String> inputAsList = convertStringToList(input);
        return areAllAlphabets.test(inputAsList);
    }
}
