
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Meal> meals = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Carb Tracker!");

        while (true) {
            System.out.println("\n1. Add Meal\n2. View Total Carbs\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1 -> addMeal();
                case 2 -> viewTotalCarbs();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addMeal() {
        System.out.print("Enter meal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter carbs (grams): ");
        double carbs = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        meals.add(new Meal(name, carbs));
        System.out.println("Meal added!");
    }

    static void viewTotalCarbs() {
        double total = meals.stream().mapToDouble(m -> m.carbs).sum();
        System.out.println("Total carbs today: " + total + "g");
    }
}

class Meal {
    String name;
    double carbs;

    Meal(String name, double carbs) {
        this.name = name;
        this.carbs = carbs;
    }
}
