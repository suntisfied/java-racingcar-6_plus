package racingcar.util;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.setting.Texts;
import racingcar.valueholder.CarName;
import racingcar.valueholder.CarNames;
import racingcar.valueholder.MaxRaceLap;

public class ConvertingUtils {
    public static List<String> convertStringToList(String listInString) {
        return Stream.of(listInString.split(Texts.DELIMITER.getText())).toList();
    }

    public static Set<String> convertStringToSet(String setInString) {
        return Stream.of(setInString.split(Texts.DELIMITER.getText())).collect(Collectors.toSet());
    }

    public static CarNames convertStringToCarNames(String input) {
        return new CarNames(convertStringToList(input).stream().map(CarName::new).toList());
    }

    public static MaxRaceLap convertStringToMaxRaceLap(String input) {
        return new MaxRaceLap(Integer.parseInt(input));
    }

    public static String convertNumberToGraphic(int driveSuccessNumber) {
        return Texts.DRIVE_GRAPHIC.getText().repeat(driveSuccessNumber);
    }

    public static List<Integer> convertStringToIntegerList(String listInString) {
        return convertStringToList(listInString).stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static Set<Integer> convertStringToIntegerSet(String setInString) {
        return convertStringToList(setInString).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
