package unknow.string_utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class JUnitStringUtilsParameterizedTest extends Assert
{
    private final CharSequence testData;
    private final boolean expected;

    public JUnitStringUtilsParameterizedTest(final CharSequence testData,
                                             final boolean expected)
    {
        this.testData = testData;
        this.expected = expected;
    }

    @Test
    public void testIsEmpty () {
        final boolean actual = StringUtils.isEmpty (testData);
        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static List<Object[]> isEmptyData() {
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Hello"});
//        System.out.println(list.get(0)[0]); // sout Hello
        return Arrays.asList(new Object[][] {
                { null, true },
                { "", true },
                { " ", false },
                { "some string", false },
        });
    }
}
