package Backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class yourList<T> implements your_Collection<T> {

   private final List<T> list;

   public yourList() {
      list = new ArrayList<>();
   }

   @Override
   public void addElement(T element) {
      list.add(element);
   }

   @Override
   public boolean removeElement(T element) {
      return list.remove(element);
   }

   @Override
   public boolean containsElement(T element) {
      return list.contains(element);
   }

   @Override
   public int size() {
      return list.size();
   }

   @Override
   public List<T> snapshot() {
      return new ArrayList<>(list);
   }

   @Override
   public Iterator<T> iterator() {
      return list.iterator();
   }
}
