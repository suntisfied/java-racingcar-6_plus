package racingcar.view.input;

import racingcar.setting.Texts;
import racingcar.valueholder.MaxRaceLap;

public class RaceLapReader extends ConsoleInputForm {
    public static MaxRaceLap readRaceLap() {
        return getInputUntilCorrect(() -> System.out.println(Texts.INSTRUCTION_INPUT_RACE_LAP.getText()),
                MaxRaceLap::new);
    }
}
