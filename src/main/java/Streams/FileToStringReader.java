package Streams;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileToStringReader {
    public static String readFile (String file) {
        try (RandomAccessFile raf = new RandomAccessFile(file,"r")){
            return raf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
