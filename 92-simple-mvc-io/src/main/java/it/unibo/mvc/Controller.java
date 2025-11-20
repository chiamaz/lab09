package it.unibo.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File file;
    private final String FILE_NAME = System.getProperty("user.home") + System.getProperty("file.separator") +"output.txt";
    private final Path path = Paths.get(FILE_NAME);
    
    public Controller() { 
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
            final FileWriter output = new FileWriter(file);
        ) {
            output.write(string);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Impossible writing on file", e);
        }
    }
}
