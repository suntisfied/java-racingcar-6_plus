package racingcar.setting;

public enum Settings {
    MINIMUM_DRIVE_TRIAL(0),
    MAXIMUM_DRIVE_TRIAL(9),
    STANDARD_TO_DRIVE(4),
    MAXIMUM_CAR_NAME_LENGTH(5),
    ;

    private final int number;

    Settings(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
