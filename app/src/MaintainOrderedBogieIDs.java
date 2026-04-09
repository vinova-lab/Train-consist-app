import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

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

        Scanner sc = new Scanner(System.in);

        // 🔹 UC11: Input validation using Regex
        System.out.print("Enter Train ID: ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        // Regex patterns
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        // Matchers
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validation
        if (trainMatcher.matches()) {
            System.out.println("Valid Train ID ✅");
        } else {
            System.out.println("Invalid Train ID ❌");
        }

        if (cargoMatcher.matches()) {
            System.out.println("Valid Cargo Code ✅");
        } else {
            System.out.println("Invalid Cargo Code ❌");
        }

        // 🔹 Create bogie list
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 50));
        bogieList.add(new Bogie("Sleeper", 80));
        bogieList.add(new Bogie("AC Chair", 55));

        // 🔹 UC7: Display original list
        System.out.println("\nPassenger Bogies (Original):");
        bogieList.forEach(System.out::println);

        // 🔹 UC7: Sort
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("\nSorted Bogies:");
        bogieList.forEach(System.out::println);

        // 🔹 UC8: Filter
        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filtered.forEach(System.out::println);

        // 🔹 UC9: Group
        Map<String, List<Bogie>> grouped = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> e : grouped.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // 🔹 UC10: Reduce (Total seats)
        int totalSeats = bogieList.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        sc.close();
    }
}