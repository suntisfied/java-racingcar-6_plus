package racingcar.util;

import java.util.List;
import java.util.function.Predicate;

public class ValidatingUtils {
    public static final Predicate<String> isPositiveInteger = input -> {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    public static final Predicate<String> isNumericString = input -> {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    public static final Predicate<List<String>> areAllElementsStrings = input ->
            input.stream().noneMatch(isNumericString);

    public static final Predicate<List<String>> areAllAlphabets = input ->
            input.stream().allMatch(element -> element != null && element.matches("[a-zA-Z]+"));
}
