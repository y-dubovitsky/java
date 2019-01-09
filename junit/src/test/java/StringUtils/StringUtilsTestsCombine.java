package StringUtils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Запуск теста может быть сконфигурирован с помощью аннотации @RunWith.
 * Тестовые классы, которые содержат в себе тестовые методы, можно объединить в наборы тестов (Suite).
 * Например, создано два класса тестирования объектов : TestFilter, TestConnect.
 * Эти два тестовых класса можно объединить в один тестовый класс
 */

/**
 * Для настройки запускаемых тестов используется аннотация @SuiteClasses, в которую включены тестовые классы.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
        StringUtilsTest.class,
        StringUtilsJUnit4Test.class
})

public class StringUtilsTestsCombine {
}
