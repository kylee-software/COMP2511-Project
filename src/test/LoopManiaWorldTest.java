package test;

import org.junit.jupiter.api.Test;

import unsw.loopmania.model.LoopManiaWorld;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Enemies.*;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.BasicItems.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;


public class LoopManiaWorldTest {

    private static int width = 5;
    private static int height = 5;

    private List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
    private LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);

    @Test
    public void receiveInventoryFullRewardsTest() {
    }

    @Test
    public void possiblySpawnEnemiesTest() {
    };

    @Test
    public void spawnVampiresFromVampireCastlesTest() {
    }

    @Test
    public void spawnZombiesFromZombiePits() {
    }

    @Test
    public void produceAlliesFromBarracksTest() {
    }

    @Test
    public void runBattlesTest() {
        
    }

    @Test
    public void loadVampireCardTest(){
    }

    @Test
    public void trapTest() {
    }

    /**
     * Test: addUnequippedItem() replaces oldest item when full
     */
    @Test
    public void addUnequippedItemTest() {
        world.addUnequippedItem("Stake");
        world.addUnequippedItem("Sword");
        world.addUnequippedItem("Shield");
        world.addUnequippedItem("Armour");
        assertEquals(world.getUnequippedItems().size(), 4);
        world.addUnequippedItem("Stake");
        world.addUnequippedItem("Sword");
        world.addUnequippedItem("Shield");
        world.addUnequippedItem("Armour");
        world.addUnequippedItem("Staff");
        world.addUnequippedItem("Helmet");
        world.addUnequippedItem("Armour");
        world.addUnequippedItem("Armour");
        world.addUnequippedItem("Sword");
        world.addUnequippedItem("Sword");
        world.addUnequippedItem("Armour");
        world.addUnequippedItem("Armour");
        assertEquals(world.getUnequippedItems().size(), 16);
        // First item should now set to type Sword
        world.addUnequippedItem("Sword");
        assertEquals(world.getUnequippedItems().size(), 16);
        Item item1 = world.getUnequippedInventoryItemEntityByCoordinates(0, 0);
        assertEquals(item1.getClass(), Sword.class);
        // Second item should now set to type Health Potion
        world.addUnequippedItem("HealthPotion");
        assertEquals(world.getUnequippedItems().size(), 16);
        Item item2 = world.getUnequippedInventoryItemEntityByCoordinates(1, 0);
        assertEquals(item2.getClass(), HealthPotion.class);
    }

    @Test
    public void removeUnequippedInventoryItemByCoordinatesTest() {
    }

    @Test
    public void runTickMovesTest() {
    }

    @Test
    public void equipItemTest() {
    }

    @Test
    public void removeUnequippedInventoryItemTest() {
    }

    @Test
    public void getUnequippedInventoryItemEntityByCoordinatesTest() {
    }

    @Test
    public void convertCardToBuildingByCoordinatesTest() {
    }

    @Test
    public void gainDiscardCardRewardsTest() {
    }

    @Test
    public void isGoalCompletedTest() {
    }

    @Test
    public void reviveCharacterTest() {
    }
}
