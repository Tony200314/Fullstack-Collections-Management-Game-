package Backend;

import java.util.Iterator;
import java.util.List;

public interface your_Collection<T> extends Iterable<T> {

    void addElement(T element);

    boolean removeElement(T element);

    boolean containsElement(T element);

    int size();

    List<T> snapshot();

    Iterator<T> iterator();
}