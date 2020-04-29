package Streams;

import java.io.*;
import java.lang.ref.SoftReference;

public class CopyFile {
    private String sourcePath;
    private String destinationPath;
    private String fileName;

    CopyFile (String sourcePath , String destinationPath , String fileName) {
        this.destinationPath = destinationPath;
        this.fileName = fileName;
        this.sourcePath = sourcePath;
    }

    public void copy () {
        new File(destinationPath).mkdirs();

        try (InputStream is = new FileInputStream(sourcePath + File.separator + fileName);
             OutputStream os = new FileOutputStream(destinationPath+ File.separator + fileName)){
            int r;
            while ((r = is.read())!=-1) {
                os.write(r);
            }
        }catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
