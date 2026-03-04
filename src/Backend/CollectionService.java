package Backend;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class CollectionService {

    private final Map<String, your_Collection<String>> collections = new HashMap<>();

    public CollectionService() {
        collections.put("list", new yourList<>());
        collections.put("set", new yourSet<>());
        collections.put("queue", new yourQueue<>());
    }

    public List<String> availableTypes() {
        List<String> types = new ArrayList<>(collections.keySet());
        Collections.sort(types);
        return types;
    }

    private your_Collection<String> resolve(String rawType) {
        if (rawType == null) {
            return collections.get("list");
        }
        return collections.getOrDefault(rawType.toLowerCase(Locale.ROOT), collections.get("list"));
    }

    public String addCity(String rawType, String city) {
        your_Collection<String> collection = resolve(rawType);
        collection.addElement(city);
        return "Hinzugefügt: " + city + " (" + typeLabel(rawType) + ")";
    }

    public List<String> route(String rawType) {
        return resolve(rawType).snapshot();
    }

    public List<String> orderedRoute(String rawType, String order) {
        List<String> view = new ArrayList<>(route(rawType));
        if (order == null || order.equalsIgnoreCase("input")) {
            return view;
        }
        if (order.equalsIgnoreCase("asc")) {
            view.sort(Comparator.naturalOrder());
        } else if (order.equalsIgnoreCase("desc")) {
            view.sort(Comparator.reverseOrder());
        }
        return view;
    }

    public boolean remove(String rawType, String city) {
        return resolve(rawType).removeElement(city);
    }

    public boolean contains(String rawType, String city) {
        return resolve(rawType).containsElement(city);
    }

    public int size(String rawType) {
        return resolve(rawType).size();
    }

    private String typeLabel(String type) {
        if (type == null) {
            return "list";
        }
        return type.toLowerCase(Locale.ROOT);
    }
}
