package second.io.file_filter;

import java.io.*;

class RewriteNumbers {
    private static File file = new File("professional/src/main/resources/second/io/file_filter/numbers.txt");

    /**
     * Get InputStream;
     * @param file
     * @return
     */
    private InputStream getInputStream(File file) {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (IOException i) {
            i.printStackTrace();
        }
        return fileInput;
    }

    /**
     * Write numbers(int) to the outputStream;
     */
    private void writeNumbers(OutputStream out, int value) {
        DataOutputStream dataOutput = new DataOutputStream(out);
        try {
            dataOutput.writeInt(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rewriteNumbers(OutputStream out, InputStream input) {
        DataInputStream dataInput = new DataInputStream(input);
        try {
            while (dataInput.available() != 0) {
                //TODO Почему тут ошибка?
                // Потому что он читает байты и должен вернуть int, но в файле int а не байты
                writeNumbers(out, (dataInput.readInt() + new Integer(1)));
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RewriteNumbers object = new RewriteNumbers();
        object.rewriteNumbers(System.out, object.getInputStream(RewriteNumbers.file));
    }

}
