package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setStringToPrint(String string);
    String getStringToPrint();
    List<String> getHistory();
    void printString() throws IllegalStateException;

}
