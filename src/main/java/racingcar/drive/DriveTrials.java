package racingcar.drive;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.setting.Settings.MAXIMUM_DRIVE_TRIAL;
import static racingcar.setting.Settings.MINIMUM_DRIVE_TRIAL;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.valueholder.MaxRaceLap;
import racingcar.valueholder.RaceLap;

public class DriveTrials {
    private final List<Integer> driveTrials;

    public DriveTrials(final List<Integer> driveTrials) {
        this.driveTrials = driveTrials;
    }

    public static List<Integer> generateDriveTrials(MaxRaceLap maxRaceLap) {
        return IntStream.range(0, maxRaceLap.number())
                .mapToObj(i -> pickNumberInRange(MINIMUM_DRIVE_TRIAL.getNumber(), MAXIMUM_DRIVE_TRIAL.getNumber()))
                .toList();
    }

    public int getTrial(RaceLap raceLap) {
        return driveTrials.get(raceLap.number());
    }

    public int getSize() {
        return driveTrials.size();
    }
}
