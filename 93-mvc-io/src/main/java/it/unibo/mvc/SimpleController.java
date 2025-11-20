package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private List<String> list = new ArrayList<>();
    private String string;

    @Override
    public void setStringToPrint(String string) {
        this.string = Objects.requireNonNull(string);
        list.add(string);
    }

    @Override
    public String getStringToPrint() {
        return this.string;
    }

    @Override
    public List<String> getHistory() {
        return this.list;
    }

    @Override
    public void printString() throws IllegalStateException {
        try {
            System.out.println(string);
        } catch (final Exception e) {
            throw new IllegalStateException();
        }
    }

}
