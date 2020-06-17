package lambda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
interface Interface<T> {
    void interfaceMethod(T t);
}

/**
 * In this class we may see how to use references on the method of class instance
 * @param <T>
 */
public class ObjectRefLambda<T extends String> {

    public void method(Interface<T> function, T a) {
        function.interfaceMethod(a);
    }

    /**
     * This method pass into other method
     * @param str
     */
    private void interfaceImpl(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        ObjectRefLambda<String> o = new ObjectRefLambda<>();
        o.method(x -> {
            System.out.println(x);
        }, "Hello");
        o.method(o::interfaceImpl, "Interface 123456 Word");
    }
}
