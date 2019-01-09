package UserUtils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Аннотация Parameterized позволяет использовать параметризированные тесты.
 * Для этого в тест-классе объявляется статический метод, возвращающий список данных,
 * которые будут использованы в качестве аргументов конструктора класса.
 */
@RunWith(Parameterized.class) // Обязательно нужно указывать!
public class UserUtilsParameterizedTest {

    UserUtils userUtils;

    public UserUtilsParameterizedTest(String str) {
        this.userUtils = new UserUtils(1, str);
    }

    @Test
    @Parameterized.Parameters
    public void testWhenUserNameOk() {
        UserUtils expected = new UserUtils(1, "Иван");
        Assert.assertEquals(expected.name, userUtils.name);
    }

    /**
     * @return - UserUtils.UserUtilsParameterizedTest.setName() must return an Iterable of arrays.
     */
    @Parameterized.Parameters
    public static String[] setName() {
        return new String[]{"Иван", "Ванюша", "Mark"};
    }
}
