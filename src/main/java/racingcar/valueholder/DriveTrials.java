package racingcar.valueholder;

import java.util.List;

public record DriveTrials(List<Integer> trials) {
    public int getTrial(RaceLap raceLap) {
        return trials.get(raceLap.number());
    }
}
