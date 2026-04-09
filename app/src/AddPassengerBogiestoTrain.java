import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after insertion
        System.out.println("\nPassenger Bogies after addition:");
        System.out.println(passengerBogies);

        // Remove a bogie (AC Chair)
        passengerBogies.remove("AC Cha

        // Display bogies after removal
        System.out.println("\nPassenger Bogies after removal:");
        System.out.println(passengerBogies);

        // Check if Sleeper exists
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nDoes Sleeper bogie exist? " + exists);

        // Final state of list
        System.out.println("\nFinal Passenger Bogies List:");
        System.out.println(passengerBogies);
    }
}