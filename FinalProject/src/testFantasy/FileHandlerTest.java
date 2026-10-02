package testFantasy;

import managerFantasy.FileHandler;
import modelFantasy.Creature;
import modelFantasy.Dragon;
import modelFantasy.Unicorn;
import modelFantasy.Phoenix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {

    private List<Creature> creatures;

    @BeforeEach
    void setUp() {
        creatures = new ArrayList<>();
        creatures.add(new Dragon("Infernox", 300, 85));
        creatures.add(new Unicorn("Luminos", 100, "Gold"));
        creatures.add(new Phoenix("Emberlorn", 500, 7));
    }

    @Test
    void testSaveCreatesFile() {
        FileHandler.saveData(creatures);
        File file = new File("creatures.txt");
        assertTrue(file.exists());
    }

    @Test
    void testLoadReturnsCorrectCount() {
        FileHandler.saveData(creatures);
        List<Creature> loaded = FileHandler.loadData();
        assertEquals(3, loaded.size());
    }

    @Test
    void testLoadReturnsCorrectSpecies() {
        FileHandler.saveData(creatures);
        List<Creature> loaded = FileHandler.loadData();
        assertEquals("Dragon", loaded.get(0).getSpecies());
        assertEquals("Unicorn", loaded.get(1).getSpecies());
        assertEquals("Phoenix", loaded.get(2).getSpecies());
    }

    @Test
    void testLoadReturnsCorrectNames() {
        FileHandler.saveData(creatures);
        List<Creature> loaded = FileHandler.loadData();
        assertEquals("Infernox", loaded.get(0).getName());
        assertEquals("Luminos", loaded.get(1).getName());
        assertEquals("Emberlorn", loaded.get(2).getName());
    }

    @Test
    void testLoadReturnsCorrectAges() {
        FileHandler.saveData(creatures);
        List<Creature> loaded = FileHandler.loadData();
        assertEquals(300, loaded.get(0).getAge());
        assertEquals(100, loaded.get(1).getAge());
        assertEquals(500, loaded.get(2).getAge());
    }

    @Test
    void testLoadFromMissingFile() {
        File file = new File("creatures.txt");
        if (file.exists()) file.delete();
        List<Creature> loaded = FileHandler.loadData();
        assertTrue(loaded.isEmpty());
    }

    @Test
    void testSaveAndLoadEmptyList() {
        FileHandler.saveData(new ArrayList<>());
        List<Creature> loaded = FileHandler.loadData();
        assertTrue(loaded.isEmpty());
    }
}