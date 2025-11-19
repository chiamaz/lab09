package it.unibo.mvc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File file;
    private static final String FILE_NAME = 
    System.getProperty("user.home") + System.getProperty("file.separator") +"output.txt";
    
    public Controller(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public String fileToString(File file) {
        return file.getAbsolutePath();
    }

    public void writeString(String string) {
        try (
            final OutputStream file1 = new FileOutputStream(file.getName());
            final DataOutputStream output = new DataOutputStream(file1);
        ) {
            output.writeUTF(string);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Impossible writing on file", e);
        }
    }
}
