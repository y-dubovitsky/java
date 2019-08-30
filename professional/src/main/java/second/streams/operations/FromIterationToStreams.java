package second.streams.operations;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FromIterationToStreams {

    /**
     * ClassLoader
     */
    static final ClassLoader loader = FromIterationToStreams.class.getClassLoader();

    /**
     * Return uri of resources
     * @return
     */
    private URI getUri() {
        URI uri = null;
        try {
            // We are insert error for testing
            uri = loader.getResource("text1.txt").toURI();
        } catch (Exception u) {
            // TODO Wrong!
            try {
                System.out.println("Ooops, we are here");
                uri = uri = loader.getResource("second/streams/operations/text.txt").toURI();
            } catch (URISyntaxException e) {
                System.out.println("Syntax error");
            }
        }
        return uri;
    }

    public void iteration() throws IOException {
        String str = new String(
                Files.readAllBytes(
                        Paths.get(
                                getUri()
                        )
                )
        );
        List<String> words = Arrays.asList(str.split("\\PL+"));

        // If we use basic java operations
        for (String s : words) {
            if (s.length() > 12) System.out.println(s);
        }

        // if we uses stream api
        words.stream()
                .filter(x -> x.length() > 12)
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        FromIterationToStreams f = new FromIterationToStreams();
        f.iteration();
    }
}
