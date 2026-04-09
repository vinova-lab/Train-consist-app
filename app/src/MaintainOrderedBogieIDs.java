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

        // 🔹 Create bogie list
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 50));
        bogieList.add(new Bogie("Sleeper", 80));
        bogieList.add(new Bogie("AC Chair", 55));

        // 🔹 UC7: Display original list
        System.out.println("Passenger Bogies (Original):");
        bogieList.forEach(System.out::println);

        // 🔹 UC7: Sort bogies by capacity
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("\nPassenger Bogies (Sorted by Capacity):");
        bogieList.forEach(System.out::println);

        // 🔹 UC8: Filter bogies (capacity > 60)
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        // 🔹 UC9: Group bogies by type
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        System.out.println("\nGrouped Bogies (By Type):");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " ->");
            for (Bogie b : entry.getValue()) {
                System.out.println("   " + b);
            }
        }

        // 🔹 UC10: Total seat calculation using reduce()
        int totalSeats = bogieList.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity: " + totalSeats);
    }
}