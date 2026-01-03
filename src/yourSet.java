import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class yourSet <T> implements your_Collection<T> {
   
    private Set set; 

    public yourSet(){
        set = new HashSet<>(); 
    }

    
    @Override 

    public void addElement(T element){
        set.add(element); 
    }

    public void removeElement(T element){
        set.remove(element); 
    }

     public int size() {
       return set.size(); 
    }

    public T containElement(T element){
        if(set.contains(element)){
            System.out.println("This is your Element: " + element);
        }
        return (T)"Sorry we can find this Element"; 
    }

    public Iterator<T> iterator(){
        return set.iterator(); 
    }
   
   
}
