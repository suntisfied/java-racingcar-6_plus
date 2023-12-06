package racingcar.util;

import java.util.stream.IntStream;
import racingcar.setting.Texts;

public class CountingUtils {
    public static int countDelimiters(String input) {
        char delimiter = Texts.DELIMITER.getText().charAt(0);
        return (int) IntStream.range(0, input.length())
                .mapToObj(input::charAt)
                .filter(character -> character == delimiter)
                .count();
    }
}
