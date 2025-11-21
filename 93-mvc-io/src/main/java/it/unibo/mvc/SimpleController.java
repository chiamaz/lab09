package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.lang.System.out;

/**
 * SimpleController implements Controller.
 *
 */
public final class SimpleController implements Controller {

    private final List<String> list = new ArrayList<>();
    private String string;

    @Override
    public void setStringToPrint(final String stringToSet) {
        this.string = Objects.requireNonNull(stringToSet);
        list.add(this.string);
    }

    @Override
    public String getStringToPrint() {
        return this.string;
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(this.list);
    }

    @Override
    public void printString() {
            if (this.string == null) {
                throw new IllegalStateException();
            }
            out.println(this.string);
    }
}
