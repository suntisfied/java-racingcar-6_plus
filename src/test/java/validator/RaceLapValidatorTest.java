package validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RaceLapValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "a",
            "-1",
            "0",
    })
    void shouldThrowIllegalArgumentExceptionToInvalidInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> RaceLapValidator.checkRaceLapValidity(input)
        );
    }
}