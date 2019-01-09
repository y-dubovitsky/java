package StringUtils;

import junit.extensions.RepeatedTest;

/**
 * Можно запустить один и тот же тест несколько раз. Для этого используем RepeatedTest:
 */
public class StringUtilsJUnit3RepeatedTest extends RepeatedTest {
    public StringUtilsJUnit3RepeatedTest() {
        super(new StringUtilsJUnit3Test(), 100);
    }
}
