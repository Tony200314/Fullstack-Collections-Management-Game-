import java.util.*;


public class HowDoesYourRouteLookslike {

    public static void main(String[] args) {
        choose_your_Collection<String> chooseyourCollection = new choose_your_Collection<String>();
        your_Collection<String> cities = chooseyourCollection.chooseYourCollection();

        while (true) {
            System.out.println("Welche neue Stadt kommt hinzu?");
            String newCity = new Scanner(System.in).nextLine();
            cities.addElement(newCity);

            System.out.printf("Wie sieht die gesamte Route aus? (Tipp: %d %s) %n",
                    cities.size(),
                    cities.size() == 1 ? "Stadt" : "Städte"
            );

            for (String city : cities) {
                String guess = new Scanner(System.in).nextLine();
                if (!city.equalsIgnoreCase(guess)) {
                    System.out.printf("%s ist nicht richtig, %s wäre korrekt. Schade!%n", guess, city);
                    return;
                }
            }
            System.out.println("Prima, alle Staädte in der richtige Reihenfolge!");

            System.out.println("1. Element eingeben und suchen");
            System.out.println("2. Dieses Element löschen");
            System.out.println("3. Alle Elemente anzeigen");
// java
            Scanner scanner = new Scanner(System.in);

// Option sicher einlesen und Zeilenende konsumieren
            int iwanToseeinside;
            if (!scanner.hasNextInt()) {
                System.out.println("Ungültige Eingabe, bitte Zahl eingeben.");
                scanner.nextLine(); // Rest der falschen Zeile verwerfen
                continue;
            }
            iwanToseeinside = scanner.nextInt();
            scanner.nextLine(); // newline nach der Zahl entfernen

            String Element;
            switch (iwanToseeinside) {
                case 1:
                    System.out.println("Bitte Element eingeben:");
                    Element = scanner.nextLine().trim();
                    cities.containElement(Element);
                    break;
                case 2:
                    System.out.println("Bitte Element eingeben:");
                    Element = scanner.nextLine().trim();
                    cities.removeElement(Element);
                    break;
                case 3:
                    Iterator<String> it = cities.iterator();
                    while (it.hasNext()) {
                        System.out.println(it.next());
                    }
                    break;
                default:
                    System.out.println("Unbekannte Option.");
                    continue;
            }
        }
    }
}

