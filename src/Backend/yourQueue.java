package Backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class yourQueue<T> implements your_Collection<T> {

    private final Queue<T> queue;

    public yourQueue() {
        queue = new PriorityQueue<>();
    }

    @Override
    public void addElement(T element) {
        queue.add(element);
    }

    @Override
    public boolean removeElement(T element) {
        return queue.remove(element);
    }

    @Override
    public boolean containsElement(T element) {
        return queue.contains(element);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public List<T> snapshot() {
        return new ArrayList<>(queue);
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }
}
