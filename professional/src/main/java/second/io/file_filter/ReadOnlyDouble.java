package second.io.file_filter;

import java.io.*;

class ReadOnlyDouble {

    private File file;

    /**
     * write the number in binary representation
     * @param out
     * @param value
     */
    public void writeDouble(OutputStream out, double value) {
        try(DataOutputStream dataOutput = new DataOutputStream(out)) {
            dataOutput.writeDouble(value);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Read double from InputStream
     * @param input
     */
    public void readDouble(InputStream input) {
        try(DataInputStream dataInput = new DataInputStream(input)) {
            while (dataInput.available() > 0) {
                System.out.println(dataInput.readDouble());
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * This method clean contents of file
     * @param path
     * @return
     */
    private File deleteFileData(String path) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(
                    file = new File(path), "rw");
            randomAccessFile.setLength(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void main(String[] args) throws Exception{
        ReadOnlyDouble readOnlyDouble = new ReadOnlyDouble();
        // записывается в файл двоично представление double числа
        readOnlyDouble.writeDouble(
                new FileOutputStream(
                        readOnlyDouble.deleteFileData(
                                "professional/src/main/resources/second/io/file_filter/numbers.txt")
                        ), 5.5);
        // read double from file
        readOnlyDouble.readDouble(
                new FileInputStream(new File("professional/src/main/resources/second/io/file_filter/numbers.txt"))
        );
    }
}
