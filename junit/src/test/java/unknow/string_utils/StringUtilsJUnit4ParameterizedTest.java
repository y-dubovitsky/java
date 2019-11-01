package unknow.string_utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

/**
 * Parameterized — довольно интересная запускалка, позволяет писать параметризированные тесты.
 * Для этого в тест-классе объявляется статический метод возвращающий список данных,
 * которые затем будут использованы в качестве аргументов конструктора класса.
 */
@RunWith(Parameterized.class)
public class StringUtilsJUnit4ParameterizedTest extends Assert {
    private final CharSequence testData;
    private final boolean expected;

    public StringUtilsJUnit4ParameterizedTest(final CharSequence testData, final boolean expected) {
        this.testData = testData;
        this.expected = expected;
    }

    @Test
    public void testIsEmpty() {
        final boolean actual = StringUtils.isEmpty(testData);
        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static List<Object[]> isEmptyData() {
        return Arrays.asList(new Object[][] {
                { null, true },
                { "", true },
                { " ", false },
                { "some string", false },
        });
    }
}
