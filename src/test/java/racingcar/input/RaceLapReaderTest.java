package racingcar.input;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.view.input.RaceLapReader;

class RaceLapReaderTest {
    @ParameterizedTest
    @CsvSource({
            "a, 3",
    })
    void readValidInputAfterInvalidOne(String invalidInput, String validInput) {
        try (MockedStatic<Console> mockConsole = Mockito.mockStatic(Console.class)) {
            mockConsole.when(Console::readLine).thenReturn(invalidInput, validInput);

            String actualInput = RaceLapReader.readRaceLap();

            assertEquals(validInput, actualInput);
        }
    }
}