package managerFantasy;

import modelFantasy.Creature;
import modelFantasy.Dragon;
import modelFantasy.Unicorn;
import modelFantasy.Phoenix;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "creatures.txt";

    public static void saveData(List<Creature> creatures) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Creature c : creatures) {
                if (c instanceof Dragon d) {
                    writer.write("Dragon," + d.getName() + "," + d.getAge() + "," + d.getFireStrength());
                } else if (c instanceof Unicorn u) {
                    writer.write("Unicorn," + u.getName() + "," + u.getAge() + "," + u.getSparkleColor());
                } else if (c instanceof Phoenix p) {
                    writer.write("Phoenix," + p.getName() + "," + p.getAge() + "," + p.getRebornCount());
                }
                writer.newLine();
            }
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static List<Creature> loadData() {
        List<Creature> creatures = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                switch (parts[0]) {
                    case "Dragon" -> creatures.add(new Dragon(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                    case "Unicorn" -> creatures.add(new Unicorn(parts[1], Integer.parseInt(parts[2]), parts[3]));
                    case "Phoenix" -> creatures.add(new Phoenix(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                    default -> System.out.println("Unknown creature type: " + parts[0]);
                }
            }
            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No save file found.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return creatures;
    }
}