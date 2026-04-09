import java.util.*;
import java.util.stream.*;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        // Create a list of passenger bogies
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 50));
        bogieList.add(new Bogie("Sleeper", 80));

        // 🔹 Display original list
        System.out.println("Passenger Bogies (Original):");
        bogieList.forEach(System.out::println);

        // 🔹 UC7: Sort bogies by capacity
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("\nPassenger Bogies (Sorted by Capacity):");
        bogieList.forEach(System.out::println);

        // 🔹 UC8: Filter bogies using Stream API (capacity > 60)
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // 🔹 Display filtered list
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);
    }
}