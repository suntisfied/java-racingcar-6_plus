package racingcar.input;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.ConvertingUtils.convertStringToCarNames;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.valueholder.CarNames;
import racingcar.view.input.CarNameReader;

class CarNameReaderTest {
    @ParameterizedTest
    @CsvSource({
            "'1,2,3', 'a,b,c'",
    })
    void readValidInputAfterInvalidOne(String invalidInput, String validInput) {
        try (MockedStatic<Console> mockConsole = Mockito.mockStatic(Console.class)) {
            mockConsole.when(Console::readLine).thenReturn(invalidInput, validInput);

            CarNames actualInput = CarNameReader.readCarNames();

            assertEquals(convertStringToCarNames(validInput), actualInput);
        }
    }
}