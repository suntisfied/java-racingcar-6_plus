package racingcar;

import racingcar.input.CarNameReader;
import racingcar.input.RaceLapReader;

public class StageManager {
    public static void proceedGame() {
        CarNameReader.readCarNames();
        RaceLapReader.readRaceLap();
    }
}
