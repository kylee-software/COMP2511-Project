package test;

import org.junit.jupiter.api.Test;

import unsw.loopmania.model.LoopManiaWorld;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Enemies.*;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.BasicItems.*;
import unsw.loopmania.model.Items.RareItems.TheOneRing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;


public class LoopManiaWorldTest {

    private static int width = 5;
    private static int height = 5;

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
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);
        // Test item creation
        world.addUnequippedItem("Stake");
        Item stake = world.getUnequippedInventoryItemEntityByCoordinates(0, 0);
        assertEquals(stake.getClass(), Stake.class);
        world.addUnequippedItem("Sword");
        Item sword = world.getUnequippedInventoryItemEntityByCoordinates(1, 0);
        assertEquals(sword.getClass(), Sword.class);
        world.addUnequippedItem("Shield");
        Item shield = world.getUnequippedInventoryItemEntityByCoordinates(2, 0);
        assertEquals(shield.getClass(), Shield.class);
        world.addUnequippedItem("Armour");
        Item armour = world.getUnequippedInventoryItemEntityByCoordinates(3, 0);
        assertEquals(armour.getClass(), Armour.class);
        assertEquals(world.getUnequippedItems().size(), 4);
        world.addUnequippedItem("Helmet");
        Item helmet = world.getUnequippedInventoryItemEntityByCoordinates(0, 1);
        assertEquals(helmet.getClass(), Helmet.class);
        world.addUnequippedItem("Staff");
        Item staff = world.getUnequippedInventoryItemEntityByCoordinates(1, 1);
        assertEquals(staff.getClass(), Staff.class);
        world.addUnequippedItem("TheOneRing");
        Item theOneRing = world.getUnequippedInventoryItemEntityByCoordinates(2, 1);
        assertEquals(theOneRing.getClass(), TheOneRing.class);
        world.addUnequippedItem("HealthPotion");
        Item healthPotion = world.getUnequippedInventoryItemEntityByCoordinates(3, 1);
        assertEquals(healthPotion.getClass(), HealthPotion.class);
        
        // Test oldest item deleted when full
        world.addUnequippedItem("Sword");
        world.addUnequippedItem("Shield");
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
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);
        // Test weapon slot
        world.addUnequippedItem("Sword");
        Item sword = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        Boolean success = world.equipItem(sword);
        assertEquals(success, true);
        world.addUnequippedItem("Stake");
        Item stake = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        assertEquals(stake.getClass(), Stake.class);
        success = world.equipItem(stake);
        assertEquals(success, false);
        world.addUnequippedItem("Staff");
        Item staff = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        assertEquals(staff.getClass(), Staff.class);
        success = world.equipItem(staff);
        assertEquals(success, false);
        // Test armour slot
        world.addUnequippedItem("Armour");
        Item armour1 = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        success = world.equipItem(armour1);
        assertEquals(success, true);
        world.addUnequippedItem("Armour");
        Item armour2 = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        success = world.equipItem(armour2);
        assertEquals(success, false);
        // Test shield slot
        world.addUnequippedItem("Shield");
        Item shield1 = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        success = world.equipItem(shield1);
        assertEquals(success, true);
        world.addUnequippedItem("Shield");
        Item shield2 = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        success = world.equipItem(shield2);
        assertEquals(success, false);
        // Test helmet slot
        world.addUnequippedItem("Helmet");
        Item helmet1 = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        success = world.equipItem(helmet1);
        assertEquals(success, true);
        world.addUnequippedItem("Helmet");
        Item helmet2 = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        success = world.equipItem(helmet2);
        assertEquals(success, false);
        // Test rare item slot
        world.addUnequippedItem("TheOneRing");
        Item theOneRing1 = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        success = world.equipItem(theOneRing1);
        assertEquals(success, true);
        world.addUnequippedItem("TheOneRing");
        Item theOneRing2 = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        success = world.equipItem(theOneRing2);
        assertEquals(success, false);
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
