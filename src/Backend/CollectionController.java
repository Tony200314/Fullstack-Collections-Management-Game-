package Backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/getConnection")
@CrossOrigin(origins = "*")
public class CollectionController {

    private final CollectionService service;

    public CollectionController(CollectionService service) {
        this.service = service;
    }

    @GetMapping("/types")
    public List<String> types() {
        return service.availableTypes();
    }

    @PostMapping("/cities")
    public ResponseEntity<Map<String, Object>> addCity(
            @RequestParam(defaultValue = "list") String type,
            @RequestBody CityRequest request) {
        if (request == null || request.city() == null || request.city().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Bitte Stadt im Request-Body angeben."));
        }
        String normalized = request.city().trim();
        String message = service.addCity(type, normalized);
        return ResponseEntity.ok(response(message, service.size(type)));
    }

    @GetMapping("/cities")
    public List<String> allCities(@RequestParam(defaultValue = "list") String type) {
        return service.route(type);
    }

    @GetMapping("/cities/order")
    public List<String> ordered(@RequestParam(defaultValue = "list") String type,
                                @RequestParam(defaultValue = "input") String direction) {
        return service.orderedRoute(type, direction);
    }

    @DeleteMapping("/cities")
    public ResponseEntity<Map<String, Object>> removeCity(
            @RequestParam String city,
            @RequestParam(defaultValue = "list") String type) {
        if (city.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Bitte Stadt im Query-Parameter city angeben."));
        }
        String normalized = city.trim();
        boolean removed = service.remove(type, normalized);
        String message = removed ? "Gelöscht: " + normalized : normalized + " nicht gefunden.";
        return ResponseEntity.ok(response(message, service.size(type)));
    }

    @GetMapping("/cities/contains")
    public Map<String, Object> contains(
            @RequestParam String city,
            @RequestParam(defaultValue = "list") String type) {
        String normalized = city.trim();
        boolean found = service.contains(type, normalized);
        Map<String, Object> payload = new HashMap<>();
        payload.put("city", normalized);
        payload.put("type", type);
        payload.put("found", found);
        return payload;
    }

    private Map<String, Object> response(String message, int size) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("message", message);
        payload.put("size", size);
        return payload;
    }

    public record CityRequest(String city) {
    }
}
