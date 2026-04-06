package Backend;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/getConnection")
@CrossOrigin(origins = "*")
public class connect {

    private final CollectionService collectionService;

    public connect(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping
    public String getCity(@RequestParam(defaultValue = "list") String rawType,
                          @RequestParam String city) {
        return collectionService.getCity(rawType, city);
    }

    @GetMapping("/types")
    public List<String> getType(){
        return collectionService.availableTypes() ; 
    }

    @PostMapping("/newCity")
    public String newCity(@RequestParam(defaultValue = "list") String rawType,
                          @RequestParam String city) {
        return collectionService.addCity(rawType, city);
    }

    @GetMapping("/route")
    public List<String> getRoute(@RequestParam(defaultValue = "list") String rawType) {
        return collectionService.route(rawType);
    }

    @GetMapping("/route/ordered")
    public List<String> getOrderedRoute(@RequestParam(defaultValue = "list") String rawType,
                                        @RequestParam(defaultValue = "input") String order) {
        return collectionService.orderedRoute(rawType, order);
    }

    @DeleteMapping("/city")
    public boolean removeCity(@RequestParam(defaultValue = "list") String rawType,
                              @RequestParam String city) {
        return collectionService.remove(rawType, city);
    }

    @GetMapping("/contains")
    public boolean containsCity(@RequestParam(defaultValue = "list") String rawType,
                                @RequestParam String city) {
        return collectionService.contains(rawType, city);
    }

    @GetMapping("/size")
    public int getSize(@RequestParam(defaultValue = "list") String rawType) {
        return collectionService.size(rawType);
    }
}
