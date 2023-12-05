package racingcar.valueholder;

import java.util.List;

public record CarNames(List<CarName> names) {
    public CarName getCarName(int number) {
        return names.get(number);
    }
}
