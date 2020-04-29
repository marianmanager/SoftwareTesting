package Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {
    public static long size (String file) {
        try {
            return Files.size(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
