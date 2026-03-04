package Backend;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class yourSet<T> implements your_Collection<T> {

    private final Set<T> set;

    public yourSet() {
        set = new HashSet<>();
    }

    @Override
    public void addElement(T element) {
        set.add(element);
    }

    @Override
    public boolean removeElement(T element) {
        return set.remove(element);
    }

    @Override
    public boolean containsElement(T element) {
        return set.contains(element);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public List<T> snapshot() {
        return new ArrayList<>(set);
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
