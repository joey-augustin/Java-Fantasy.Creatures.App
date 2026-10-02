package managerFantasy;

import modelFantasy.Creature;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreatureManager {

    private List<Creature> creatures = new ArrayList<>();

    public void addCreature(Creature creature) {
        creatures.add(creature);
        System.out.println(creature.getName() + " has been added!");
    }

    public void removeCreature(String name) {
        Creature toRemove = null;
        for (Creature c : creatures) {
            if (c.getName().equalsIgnoreCase(name)) {
                toRemove = c;
                break;
            }
        }
        if (toRemove != null) {
            creatures.remove(toRemove);
            System.out.println(toRemove.getName() + " has been removed!");
        } else {
            System.out.println("Creature not found.");
        }
    }

    public void displayCreatures() {
        if (creatures.isEmpty()) {
            System.out.println("No creatures to display.");
        } else {
            creatures.forEach(c -> System.out.println(c.getDetails()));
        }
    }

    public void filterByType(String species) {
        List<Creature> filtered = creatures.stream()
                .filter(c -> c.getSpecies().equalsIgnoreCase(species))
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            System.out.println("No creatures of type " + species + " found.");
        } else {
            filtered.forEach(c -> System.out.println(c.getDetails()));
        }
    }

    public void showStatistics() {
        System.out.println("Total Creatures: " + creatures.size());
        System.out.println("Dragons: " + creatures.stream().filter(c -> c.getSpecies().equalsIgnoreCase("Dragon")).count());
        System.out.println("Unicorns: " + creatures.stream().filter(c -> c.getSpecies().equalsIgnoreCase("Unicorn")).count());
        System.out.println("Phoenixes: " + creatures.stream().filter(c -> c.getSpecies().equalsIgnoreCase("Phoenix")).count());
        creatures.stream().mapToInt(Creature::getAge).average()
                .ifPresent(avg -> System.out.printf("Average Age: %.1f%n", avg));
    }

    public List<Creature> getCreatures() { return creatures; }
    public void setCreatures(List<Creature> creatures) { this.creatures = creatures; }
}