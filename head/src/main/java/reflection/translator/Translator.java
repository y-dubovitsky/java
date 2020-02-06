package reflection.translator;

/**
 * This interface must be implements all classes, which translate language.
 */
public interface Translator {

    /**
     * This method translate original text
     * @param source - source txt
     * @param in - lang in
     * @param out - lang out
     * @return - translate result
     */
    public String translate(String source, String in, String out);
}
