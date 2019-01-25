package io20.bytes.page743;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintStreamShow {
    public static void main(String[] args) {
        File output = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\page743\\txt.txt");
        String str = "Простыми словами при открытии файла операционная система " +
                "создает запись для представления этого файла и сохраняет информацию об этом открывшемся файле. " +
                "Итак, если в вашей ОС открыто 100 файлов, то в ОС будет находиться 100 записей (где-то в ядре). " +
                "Эти записи представлены целыми числами типа (... 100, 101, 102....). " +
                "Этот номер записи является файловым дескриптором. " +
                "Таким образом, это просто целое число, которое уникально представляет собой открытый " +
                "файл в операционной системе. Если ваш процесс откроет 10 файлов, ваша таблица процессов " +
                "будет содержать 10 записей для дескрипторов файлов.\n" +
                "\n" +
                "Аналогично, когда вы открываете сетевой сокет, он также представляется целым числом и " +
                "называется дескриптором Socket. Надеюсь, вы понимаете.";
        try (PrintStream p = new PrintStream(output, StandardCharsets.UTF_8); ByteArrayInputStream b = new ByteArrayInputStream(str.getBytes())) {
            int value;
            while((value = b.read()) != -1) {
                p.print((char)value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
