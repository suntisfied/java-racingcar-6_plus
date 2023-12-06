package racingcar.util;

public class TextUtils {
    public static String removeLastBlank(String input) {
        if (!input.isEmpty() && input.endsWith(System.lineSeparator())) {
            return input.substring(0, input.length() - System.lineSeparator().length());
        }
        return input;
    }
}
