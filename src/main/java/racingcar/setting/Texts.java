package racingcar.setting;

public enum Texts {
    INSTRUCTION_INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 기분"),
    INSTRUCTION_INPUT_RACE_LAP("시도할 횟수는 몇회인가요?"),
    ERROR_INVALID_CAR_NAMES("[ERROR] 올바른 차량명 입력이 아닙니다."),
    ERROR_INVALID_RACE_LAP("[ERROR] 올바른 횟수 입력이 아닙니다."),
    HEAD_RESULT("실행 결과"),
    HEAD_WINNER("최종 우승자 : "),
    DELIMITER(","),
    ;

    public final String text;

    Texts(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
