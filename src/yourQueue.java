import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class yourQueue <T> implements your_Collection<T> {
    
    Queue queue; 

    public yourQueue(){
        queue = new PriorityQueue<>(); 
    }


    @Override 

    public void addElement(T element){
        queue.add(element); 
    }

    public void removeElement(T element){
        queue.remove(element); 
    }

    public int size() {
        return queue.size(); 
    }

    public T containElement(T element){
        if (queue.contains(element)) {
            System.out.println("This is your Element: " + element);
        }

        return (T)"Sorry we can find this Element"; 
    }

    public Iterator<T> iterator(){
        return queue.iterator(); 
    }
}
