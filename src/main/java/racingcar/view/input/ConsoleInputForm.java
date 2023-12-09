package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public abstract class ConsoleInputForm {
    @FunctionalInterface
    public interface InputWrapper<T> {
        T wrapInput(String input) throws IllegalArgumentException;
    }

    protected static <T> T getInputUntilCorrect(Runnable instruction, InputWrapper<T> inputWrapper) {
        instruction.run();
        String input = Console.readLine();

        try {
            return inputWrapper.wrapInput(input);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getInputUntilCorrect(instruction, inputWrapper);
        }
    }
}
