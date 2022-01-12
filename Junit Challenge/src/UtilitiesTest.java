import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    private Utilities utilities;

    @BeforeEach
    public void initializer() {
        utilities = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        char[] array = {'h', 'e', 'l', 'l', 'o'};
        char[] expected = {'e', 'l'};
        assertArrayEquals(expected, utilities.everyNthChar(array, 2));
        assertArrayEquals(array, utilities.everyNthChar(array, (array.length + 1)));
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));
        assertNull(null, utilities.removePairs(null));
        assertEquals("A", utilities.removePairs("A"));
        assertEquals("", utilities.removePairs(""));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        int expectedResult = 300;
        assertEquals(expectedResult, utilities.converter(10, 5));
        assertThrows(ArithmeticException.class, () -> {
            utilities.converter(10, 0);
        });
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        String evenString = "Good";
        String oddString = "Hello";
        String expectedString = "Good";
        assertEquals(expectedString, utilities.nullIfOddLength(evenString));
        assertNull(utilities.nullIfOddLength(oddString));
    }

    @ParameterizedTest
    @CsvSource({"ABCDEFF, ABCDEF", "AB88EFFG, AB8EFG", "112233445566, 123456", "A, A"})
    void removePairsParameterized(String first, String second) {
        assertEquals(second, utilities.removePairs(first));
    }
}