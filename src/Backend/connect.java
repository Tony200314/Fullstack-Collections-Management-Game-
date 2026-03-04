package Backend;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/getConnection")
@CrossOrigin(origins = "*")
public class connect {

    private final your_Collection<String> list  = new yourList<>();
    private final your_Collection<String> set   = new yourSet<>();
    private final your_Collection<String> queue = new yourQueue<>();

    private your_Collection<String> pick(String type) {
        if (type == null) return list; // default
        return switch (type.toLowerCase()) {
            case "set" -> set;
            case "queue" -> queue;
            default -> list;
        };
    }

    @GetMapping("/add")
    public String addCity(@RequestParam String city,
                          @RequestParam(required = false, defaultValue = "list") String type) {
        if (city == null || city.isBlank()) {
            return "Bitte eine gültige Stadt angeben (z.B. /getConnection/add?city=Berlin&type=list)";
        }
        your_Collection<String> target = pick(type);
        target.addElement(city);
        return "Hinzugefügt: " + city + " in " + type;
    }


    @GetMapping("/all")
    public List<String> all(@RequestParam(required = false, defaultValue = "list") String type) {
        your_Collection<String> target = pick(type);
        List<String> out = new ArrayList<>();
        for (String s : target) out.add(s);
        return out; // JSON-Array
    }

    @GetMapping("/order")
    public List<String> order(@RequestParam(required = false, defaultValue = "list") String type,
                              @RequestParam(required = false, defaultValue = "input") String dir) {
        your_Collection<String> target = pick(type);

        // 1) In List kopieren
        List<String> view = new ArrayList<>();
        for (String s : target) view.add(s);

        // 2) Optional sortieren
        switch (dir == null ? "input" : dir.toLowerCase()) {
            case "asc"  -> view.sort(Comparator.naturalOrder());
            case "desc" -> view.sort(Comparator.reverseOrder());
            default -> { /* keine Sortierung */ }
        }

        // 3) Nummerieren
        List<String> numbered = new ArrayList<>(view.size());
        for (int i = 0; i < view.size(); i++) {
            numbered.add((i + 1) + ". " + view.get(i));
        }
        return numbered;
    }
}
