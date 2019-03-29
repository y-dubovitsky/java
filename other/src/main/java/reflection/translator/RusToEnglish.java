package reflection.translator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class use regex and replace each symbol to number.
 */
public class RusToEnglish implements Translator {
    @Override
    public String translate(String source, String in, String out) {
        Pattern pattern = Pattern.compile("[а-я]*");
        Matcher matcher = pattern.matcher(source);
        return matcher.replaceAll("1");
    }
}
