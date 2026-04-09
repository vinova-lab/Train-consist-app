import java.util.HashMap;
import java.util.Map;

public class TrainApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Create HashMap to store bogie-capacity mapping
        Map<String, Integer> bogieCapacity = new HashMap<>();

        // Insert capacities for passenger bogies
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 54);
        bogieCapacity.put("First Class", 36);

        // Display bogie capacities
        System.out.println("\nBogie Capacities:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " seats");
        }
    }
}