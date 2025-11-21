package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {

    public static final String SEP = File.separator;
    private static final String FILE_NAME = System.getProperty("user.home") + SEP + "output.txt";
    private final Path path = Paths.get(FILE_NAME);
    private File file;

    /**
     * Constructor.
     */
    public Controller() { 
        this.file = path.toFile();
    }

    /**
     * Sets a File as current file.
     * 
     * @param fileCurr the file to set.
     */
    public void setCurrentFile(final File fileCurr) {
        this.file = fileCurr;
    }

    /**
     * Gets the current File.
     * 
     * @return the current File.
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Gets the path (in form of String) of the current `File`.
     * 
     * @return the path of the file.
     */
    public String getFilePath() {
        return this.file.getAbsolutePath();
    }

    /**
     * Gets a `String` as input and saves its content on the current file. 
     * This method may throw an `IOException`.
     * 
     * @param string the string to save in the file.
     */
    public void writeString(final String string) {
        try (
            BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)
        ) {
            writer.write(string);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Impossible writing on file", e);
        }
    }
}
