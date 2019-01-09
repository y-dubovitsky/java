package StringUtils;

import junit.framework.TestSuite;

/**
 * Можно группировать тесты. Для этого нужно использовать класс TestSuite:
 */
public class StringUtilsJUnit3TestSuite extends TestSuite {
    /**
     * Сама группировка тестов
     */
    public StringUtilsJUnit3TestSuite() {
        addTestSuite(StringUtilsJUnit3Test.class);
        addTestSuite(StringUtilsTest.class);
        //addTestSuite(OtherTest2.class);
    }
}
