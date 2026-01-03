import java.util.*;

public interface your_Collection <T> extends Iterable<T>  {

    public void addElement(T element); 

    public void removeElement(T element); 

    public T containElement (T element);

    public int size(); 

   public Iterator<T> iterator();
}