//package junit3;
//
//import junit.extensions.ExceptionTestCase;
//
///**
// * Наследуя тест-класс от ExceptionTestCase, можно проверить что-либо на выброс исключения:
// */
//public class StringUtilsJUnit3ExceptionTest extends ExceptionTestCase {
//    public StringUtilsJUnit3ExceptionTest(final String name) {
//        super(name, NullPointerException.class);
//    }
//
//    public void testToHexString() {
//        StringUtils.toHexString(null);
//    }
//}
