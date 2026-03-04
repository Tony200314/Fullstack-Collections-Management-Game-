package Backend;

import java.util.*;


public class choose_your_Collection <T>  {
    private final your_Collection<T> list = new yourList<>();
    private final your_Collection<T> set = new yourSet<>();
    private final your_Collection<T> queue = new yourQueue<>();

    public your_Collection<T> chooseYourCollection(){
        
        System.out.println("Welche Datenstruktur willst du nutzen ");
        System.out.println();

        System.out.println("A. List ");
        System.out.println("B. Set");
        System.out.println("C. Queue");

      String choose = new Scanner(System.in).nextLine(); 
        switch (choose) {

            case "A":
               return list; 

            case "B":
               return set; 

            case "C": 
                return queue; 
        
            default:
                return null;
        }
    }

}
