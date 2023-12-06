package validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarNameValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "a",
            "a,b,c,d,e,f",
            "a,a,b",
            "a,,b",
    })
    void shouldThrowIllegalArgumentExceptionToInvalidInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> CarNameValidator.checkCarNameInputValidity(input)
        );
    }
}