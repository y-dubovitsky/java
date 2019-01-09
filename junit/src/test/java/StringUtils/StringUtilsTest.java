package StringUtils;

import junit.framework.TestCase;

/**
 * JUnit 3
 *
 * Для создания теста нужно унаследовать тест-класс от TestCase,
 * переопределить методы setUp и tearDown если надо, ну и самое главное — создать тестовые методы(должны начинаться с test).
 * При запуске теста сначала создается экземляр тест-класса(для каждого теста в классе отдельный экземпляр класса),
 * затем выполняется метод setUp, запускается сам тест, ну и в завершение выполняется метод tearDown.
 * Если какой-либо из методов выбрасывает исключение, тест считается провалившимся.

 Примечание: тестовые методы должны быть public void, могут быть static.

 Сами тесты состоят из выполнения некоторого кода и проверок.
 Проверки чаще всего выполняются с помощью класса Assert хотя иногда используют ключевое слово assert.
 */
public class StringUtilsTest extends TestCase {
    /**
     * Тест
     */
    public void testIsEmpty() {
        boolean actual = StringUtils.isEmpty(null);
        assertTrue(actual);

        actual = StringUtils.isEmpty("");
        assertTrue(actual);

        actual = StringUtils.isEmpty(" ");
        assertFalse(actual);

        actual = StringUtils.isEmpty("some string");
        assertFalse(actual);
    }
}