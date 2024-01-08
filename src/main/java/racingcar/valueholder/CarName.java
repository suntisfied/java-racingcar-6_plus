package racingcar.valueholder;

import racingcar.view.inputvalidator.CarNameValidator;

public record CarName(String name) {
    public CarName {
        CarNameValidator.checkCarNameInputValidity(name);
    }
}
