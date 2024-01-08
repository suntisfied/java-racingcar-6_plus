package racingcar.valueholder;

import racingcar.view.inputvalidator.RaceLapValidator;

public record MaxRaceLap(int number) {
    public MaxRaceLap(final String number) {
        this(parseNumber(number));
    }

    private static int parseNumber(String number) {
        RaceLapValidator.checkRaceLapValidity(number);
        return Integer.parseInt(number);
    }
}
