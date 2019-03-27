package regex30.page1098;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class show how to use sequence symbols in pattern regex.
 */
public class SymbolClass {
    public static void main(String[] args) {

        // +  - one or more time
        // * - zero or more time
        // ? - zero or one time
        String seqSymbol = "[qwe]+.*";

        Pattern pattern = Pattern.compile(seqSymbol);
        Matcher matcher = pattern.matcher("package regex30.page1098;\n" +
                "\n" +
                "import java.util.regex.Matcher;\n" +
                "import java.util.regex.Pattern;\n" +
                "\n" +
                "/**\n" +
                " * This class show how to use sequence symbols in pattern regex.\n" +
                " */\n" +
                "public class SymbolClass {\n" +
                "    public static void main(String[] args) {\n" +
                "        String seqSymbol = \"[qwe]\";\n" +
                "\n" +
                "        Pattern pattern = Pattern.compile(seqSymbol);\n" +
                "        Matcher matcher = pattern.matcher()\n" +
                "    }\n" +
                "}\n");
        boolean end = matcher.find();
        while (end) {
            System.out.println(matcher.group());
            end = matcher.find();
        }
    }
}
