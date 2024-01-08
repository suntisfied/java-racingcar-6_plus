package racingcar.view.inputvalidator;

import java.util.function.BooleanSupplier;

public abstract class InputValidatorForm {
    protected static void throwIllegalArgumentExceptionToInvalid(String errorMessage, BooleanSupplier inputValidator) {
        if (!inputValidator.getAsBoolean()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
