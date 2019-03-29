package reflection.translator;

/**
 * This class show how to use reflection to create Object from Class class;
 * And use interface to transfer various object whose implement common interface.
 */
public class LanguageTranslator {

    static String text = "Исходный текст, который нужно перевести";
    static String lang1 = "English";
    static String lang2 = "Russian";

    public String universalTranslate() {

        String result = null;

        try {
            // get a Class class object
            Class clazz = Class.forName("reflection.translator.RusToEnglish");

            // get a Object which implement Translator interface
            Object o = clazz.newInstance();

            // checking types
            if (o instanceof Translator) {
                result = ((Translator) o).translate(text, lang1, lang2);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        LanguageTranslator languageTranslator = new LanguageTranslator();
        System.out.println(languageTranslator.universalTranslate());
    }
}
