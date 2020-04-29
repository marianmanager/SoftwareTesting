package Streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class StringToFileWriter {
    //nume file
    private String fileName;
    //referinta unde se va salva fila
    private String basePath;

    StringToFileWriter(String fileName, String basePath) {
        this.fileName = fileName;
        this.basePath = basePath;
    }

    //creem o metoda care scrie textul catre fila
     public void write(String text) {
        try (Writer fileWriter = new FileWriter(basePath + File.separator + fileName + ".txt")){
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}
