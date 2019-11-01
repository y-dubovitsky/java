package unknow.string_utils;

import junit.framework.Assert;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Для упрощения работы я предпочитаю наследоваться от класса Assert, хотя это необязательно.

 Аннотация @AfterClass связана по смыслу с @BeforeClass, но выполняет методы после теста,
 как и в случае с @BeforeClass, методы должны быть public static void.

 */
public class StringUtilsJUnit4Test extends Assert {
    private final Map<String, byte[]> toHexStringData = new HashMap<String, byte[]>();

    /**
     *  Аннотация @BeforeClass обозначает методы, которые будут вызваны до создания экземпляра тест-класса,
     методы должны быть public static void. Имеет смысл размещать предустановки для теста в случае,
     когда класс содержит несколько тестов использующих различные предустановки,
     либо когда несколько тестов используют одни и те же данные, чтобы не тратить время на их создание для каждого теста.
     */
    @BeforeClass
    public static void runBeforeTestClass() {
        System.out.println("Hello! I used before create an object StringUtilsJUnit4Test");
    }

    /**
     *  Аннотация Before обозначает методы, которые будут вызваны до исполнения теста, методы должны быть public void.
     Здесь обычно размещаются предустановки для теста, в нашем случае это генерация тестовых данных (метод setUpToHexStringData).
     */
    @Before
    public void setUpToHexStringData() {
        toHexStringData.put("", new byte[0]);
        toHexStringData.put("01020d112d7f", new byte[] { 1, 2, 13, 17, 45, 127 });
        toHexStringData.put("00fff21180", new byte[] { 0, -1, -14, 17, -128 });
        //...
    }

    /**
     *  Аннотация @After обозначает методы, которые будут вызваны после выполнения теста, методы должны быть public void.
     Здесь размещаются операции освобождения ресурсов после теста,
     в нашем случае — очистка тестовых данных (метод tearDownToHexStringData).
     */
    @After
    public void tearDownToHexStringData() {
        toHexStringData.clear();
    }

    /**
     *  Аннотация @Test обозначает тестовые методы. Как и ранее, эти методы должны быть public void.
     Здесь размещаются сами проверки. Кроме того, у данной аннотации есть два параметра,
     expected — задает ожидаемое исключение и timeout — задает время, по истечению которого тест считается провалившимся.
     */
    @Test
    public void testToHexString() {
        for (Map.Entry<String, byte[]> entry : toHexStringData.entrySet()) {
            final byte[] testData = entry.getValue();
            final String expected = entry.getKey();
            final String actual = StringUtils.toHexString(testData);
            assertEquals(expected, actual);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testToHexStringWrong() {
        StringUtils.toHexString(null);
    }

    @Test(timeout = 1000)
    public void infinity() {
        while (true);
    }

    /**
     * Если какой-либо тест по какой-либо серьезной причине нужно отключить(например,
     * этот тест постоянно валится, но его исправление отложено до светлого будущего)
     * его можно зааннотировать @Ignore. Также, если поместить эту аннотацию на класс,
     * то все тесты в этом классе будут отключены.
     */
    @Ignore
    @Test(timeout = 1000)
    public void infinityIgnore() {
        while (true);
    }
}
