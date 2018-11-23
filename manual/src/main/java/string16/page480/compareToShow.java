package main.java.string16.page480;

public class compareToShow {
    static String[] stringArray = new String[]{"a", "b", "c", "qwe", "QwE", "Matthey", "Babo", "123", "@#$", "my name is.."};

    public static void main(String[] args) {
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray.length; j++) {
                String t;
                if (stringArray[i].compareTo(stringArray[j]) > 0) {
                    t = stringArray[j];
                    stringArray[j] = stringArray[i];
                    stringArray[i] = t;
                }
            }
        }
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i] + " ");
        }
        System.out.print(System.lineSeparator());
        System.out.println("Вхождение первого символа R - " + new String("QWR reye ert e yeryrey ERT").indexOf("R"));
    }
}
