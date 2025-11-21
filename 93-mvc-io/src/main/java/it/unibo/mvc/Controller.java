package it.unibo.mvc;

import java.util.List;

/**
 * Controller interface.
 */
public interface Controller {

    /**
     * Sets the next string to print.
     * 
     * @param string the next string to print.
     */
    void setStringToPrint(String string);

    /**
     * Gets the next string to print.
     * 
     * @return the next string to print.
     */
    String getStringToPrint();

    /**
     * Gets the history of the printed strings.
     * 
     * @return the history of the printed strings.
     */
    List<String> getHistory();

    /**
     * Prints the current string.
     * 
     * @throws IllegalStateException if the current string is unset
     */
    void printString();

}
