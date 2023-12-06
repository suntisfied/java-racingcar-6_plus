package racingcar.util;

public class TextUtils {
    public static final String LINE_BREAK = System.lineSeparator();

    public static String removeLastBlank(String input) {
        if (!input.isEmpty() && input.endsWith(LINE_BREAK)) {
            return input.substring(0, input.length() - LINE_BREAK.length());
        }
        return input;
    }
}
