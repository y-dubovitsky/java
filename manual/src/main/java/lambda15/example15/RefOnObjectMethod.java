package lambda15.example15;

interface Interface {
    abstract String getFromInterface(String str);
}

public class RefOnObjectMethod {
    /**
     * Функция совместимая с методои из функционального интерфейса.
     * @param str
     * @return
     */
    String fromObject(String str) {
        String result = "";
        int i = str.length() - 1;
        do {
            result += str.charAt(i);
            i--;
        } while (i >= 0);
        return result;
    }

    /**
     * Non static function
     * @param i
     * @param str
     * @return
     */
    String func(Interface i, String str) {
        return i.getFromInterface(str);
    }

    /**
     * Static function
     * @param i
     * @param str
     * @return
     */
    static String staticFun(Interface i, String str) {
        return i.getFromInterface(str) + "Hello from static";
    }

    public static void main(String[] args) {
        RefOnObjectMethod ref = new RefOnObjectMethod();
        System.out.println(ref.func(ref::fromObject, "Hello my darling"));
        // Имя класса не указывается
        System.out.println(staticFun(ref::fromObject, "Hello from static twice"));
    }
}

class Example {
    public static void main(String[] args) {
        RefOnObjectMethod ref = new RefOnObjectMethod();
        System.out.println(ref.func(ref::fromObject, "Example Example"));
        // При вызове статического метода указывается имя класса
        System.out.println(RefOnObjectMethod.staticFun(ref::fromObject, "Hello from Example Example"));
    }
}
