package mainFantasy;

import managerFantasy.CreatureManager;
import managerFantasy.FileHandler;
import modelFantasy.Dragon;
import modelFantasy.Unicorn;
import modelFantasy.Phoenix;

import java.util.Scanner;

public class FantasyCreatureSystem {

    private static final CreatureManager manager = new CreatureManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("----Welcome to the Fantasy Creature System----");
        System.out.println();


        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> addCreature();
                case 2 -> removeCreature();
                case 3 -> manager.displayCreatures();
                case 4 -> filterByType();
                case 5 -> manager.showStatistics();
                case 6 -> FileHandler.saveData(manager.getCreatures());
                case 7 -> manager.setCreatures(FileHandler.loadData());
                case 8 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n1. Add Creature");
        System.out.println("2. Remove Creature");
        System.out.println("3. Display Creatures");
        System.out.println("4. Filter by Type");
        System.out.println("5. Show Statistics");
        System.out.println("6. Save Data");
        System.out.println("7. Load Data");
        System.out.println("8. Exit");
    }

    private static void addCreature() {
        System.out.println("Select species:");
        System.out.println("1. Dragon");
        System.out.println("2. Unicorn");
        System.out.println("3. Phoenix");
        int species = readInt("Enter species: ");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        int age = readInt("Enter age: ");

        switch (species) {
            case 1 -> {
                int fireStrength = readInt("Enter fire strength (1-100): ");
                manager.addCreature(new Dragon(name, age, fireStrength));
            }
            case 2 -> {
                System.out.print("Enter sparkle color: ");
                String sparkleColor = scanner.nextLine();
                manager.addCreature(new Unicorn(name, age, sparkleColor));
            }
            case 3 -> {
                int rebornCount = readInt("Enter reborn count: ");
                manager.addCreature(new Phoenix(name, age, rebornCount));
            }
            default -> System.out.println("Invalid species.");
        }
    }

    private static void removeCreature() {
        System.out.print("Enter the name of the creature to remove: ");
        String name = scanner.nextLine();
        manager.removeCreature(name);
    }

    private static void filterByType() {
        System.out.println("Select species to filter by:");
        System.out.println("1. Dragon");
        System.out.println("2. Unicorn");
        System.out.println("3. Phoenix");
        int choice = readInt("Enter species: ");
        switch (choice) {
            case 1 -> manager.filterByType("Dragon");
            case 2 -> manager.filterByType("Unicorn");
            case 3 -> manager.filterByType("Phoenix");
            default -> System.out.println("Invalid choice.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}