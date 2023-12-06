package racingcar.util;

import static racingcar.util.ConvertingUtils.convertStringToList;
import static racingcar.util.ConvertingUtils.convertStringToSet;
import static racingcar.util.CountingUtils.countDelimiters;

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

    public static final Predicate<String> areAllElementsStrings = input -> {
        List<String> inputAsList = convertStringToList(input);
        return inputAsList.stream().noneMatch(isNumericString);
    };

    public static final Predicate<String> areAllAlphabets = input -> {
        List<String> inputAsList = convertStringToList(input);
        return inputAsList.stream().allMatch(element -> element != null && element.matches("[a-zA-Z]+"));
    };

    public static final Predicate<String> isProperCarNameNumber = input -> {
        List<String> inputAsList = convertStringToList(input);
        return inputAsList.size() >= 2 && inputAsList.size() <= 5;
    };

    public static final Predicate<String> isUniqueOnly = input ->
            convertStringToList(input).size() == convertStringToSet(input).size();

    public static final Predicate<String> isUsingProperDelimiter = input ->
            countDelimiters(input) == convertStringToList(input).size() - 1;
}
