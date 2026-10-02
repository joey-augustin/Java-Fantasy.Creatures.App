package testFantasy;

import managerFantasy.CreatureManager;
import modelFantasy.Dragon;
import modelFantasy.Unicorn;
import modelFantasy.Phoenix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreatureManagerTest {

    private CreatureManager manager;

    @BeforeEach
    void setUp() {
        manager = new CreatureManager();
        manager.addCreature(new Dragon("Infernox", 300, 85));
        manager.addCreature(new Unicorn("Luminos", 100, "Gold"));
        manager.addCreature(new Phoenix("Emberlorn", 500, 7));
    }

    @Test
    void testAddCreature() {
        assertEquals(3, manager.getCreatures().size());
    }

    @Test
    void testRemoveCreature() {
        manager.removeCreature("Infernox");
        assertEquals(2, manager.getCreatures().size());
    }

    @Test
    void testRemoveNonExistentCreature() {
        manager.removeCreature("Unknown");
        assertEquals(3, manager.getCreatures().size());
    }

    @Test
    void testFilterByType() {
        long dragonCount = manager.getCreatures().stream()
                .filter(c -> c.getSpecies().equalsIgnoreCase("Dragon"))
                .count();
        assertEquals(1, dragonCount);
    }

    @Test
    void testShowStatisticsNotEmpty() {
        assertFalse(manager.getCreatures().isEmpty());
    }

    @Test
    void testAverageAge() {
        double avg = manager.getCreatures().stream()
                .mapToInt(c -> c.getAge())
                .average()
                .orElse(0);
        assertEquals((300 + 100 + 500) / 3.0, avg, 0.01);
    }

    @Test
    void testDragonAbility() {
        Dragon d = new Dragon("Blaze", 50, 90);
        assertTrue(d.useAbility().contains("Blaze"));
    }

    @Test
    void testUnicornAbility() {
        Unicorn u = new Unicorn("Starlight", 60, "Silver");
        assertTrue(u.useAbility().contains("Silver"));
    }

    @Test
    void testPhoenixAbility() {
        Phoenix p = new Phoenix("Ash", 200, 3);
        assertTrue(p.useAbility().contains("3"));
    }
}