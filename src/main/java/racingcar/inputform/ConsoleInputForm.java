package racingcar.inputform;

import camp.nextstep.edu.missionutils.Console;

public abstract class ConsoleInputForm {
    @FunctionalInterface
    public interface InputInspector {
        void inspectInput(String input) throws IllegalArgumentException;
    }

    protected static String getInputUntilCorrect(Runnable instruction, InputInspector inputInspector) {
        instruction.run();
        String input = Console.readLine();

        try {
            inputInspector.inspectInput(input);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getInputUntilCorrect(instruction, inputInspector);
        }
        return input;
    }
}
