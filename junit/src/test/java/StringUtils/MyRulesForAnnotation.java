package StringUtils;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Правила

 Кроме всего вышеперечисленного есть довольно интересная вещь — правила.
 Правила это некое подобие утилит для тестов, которые добавляют функционал до и после выполнения теста.

 Например, есть встроенные правила для задания таймаута для теста(Timeout),
 для задания ожидаемых исключений(ExpectedException), для работы с временными файлами(TemporaryFolder) и д.р.
 Для объявления правила необходимо создать public не static поле типа производного от MethodRule и зааннотировать его
 с помощью Rule.
 */
public class MyRulesForAnnotation {

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public final Timeout timeout = new Timeout(1000);

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Ignore
    @Test
    public void anotherInfinity() {
        while (true);
    }

    @Test
    public void testFileWriting() throws IOException {
        final File log = folder.newFile("debug.log");
        final FileWriter logWriter = new FileWriter(log);
        logWriter.append("Hello, ");
        logWriter.append("World!!!");
        logWriter.flush();
        logWriter.close();
    }

    @Test
    public void testExpectedException() throws IOException {
        thrown.expect(NullPointerException.class);
        StringUtils.toHexString(null);
    }
}

