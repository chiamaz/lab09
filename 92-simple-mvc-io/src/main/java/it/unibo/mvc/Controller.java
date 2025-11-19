package it.unibo.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File file;
    
    public Controller() { 
        final String FILE_NAME = 
        System.getProperty("user.home") + System.getProperty("file.separator") +"output.txt";
        final Path path = Paths.get(FILE_NAME);
        this.file = path.toFile();
    }

    public void setCurrentFile(File file){
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public String getFilePath() {
        return this.file.getAbsolutePath();
    }

    public void writeString(String string) {
        try (
            final FileOutputStream output = new FileOutputStream(this.file);
        ) {
            output.write(string.getBytes());
        } catch (final IOException e) {
            throw new IllegalArgumentException("Impossible writing on file", e);
        }
    }
}
