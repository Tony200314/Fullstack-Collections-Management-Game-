import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class yourList <T> implements your_Collection<T> {
    
   private List list; 

     public yourList(){
        list = new ArrayList<>(); 
     }


     @Override

     public void addElement(T element){
        list.add(element); 
     }

     public void removeElement(T element){
        list.remove(element); 
     }

     public int size() {
        return list.size(); 
     }

     public T containElement(T element){
        if(list.contains(element)){
            System.out.println("this the Element you want : " + element);
        }
        return (T)"Sorry we can find this Element"; 
     }

     public Iterator<T> iterator(){
      return list.iterator(); 
     }
}
