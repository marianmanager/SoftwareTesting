package Streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamExample {
    public static void main(String[] args) {
        write("some text");
    }

    public static void write (String text) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(
                    "D:\\test.txt"
            );
            for(char c : text.toCharArray()) {
                outputStream.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null ) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
